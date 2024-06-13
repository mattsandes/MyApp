package br.com.sandes.MyApi.services;

import br.com.sandes.MyApi.data.dto.v1.security.AccountCredentialsDTO;
import br.com.sandes.MyApi.data.dto.v1.security.TokenDTO;
import br.com.sandes.MyApi.repositories.UserRepository;
import br.com.sandes.MyApi.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private final JwtTokenProvider tokenProvider;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final UserRepository repository;

    public AuthService(JwtTokenProvider tokenProvider,
                       AuthenticationManager authenticationManager,
                       UserRepository repository) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.repository = repository;
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity signing(AccountCredentialsDTO data){
        try {
            var username = data.getUsername();
            var password = data.getPassword();

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            var user = repository.findByUsername(username);

            var tokenReponse = new TokenDTO();

            if(user != null){
                tokenReponse = tokenProvider.createAccessToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }

            return ResponseEntity.ok(tokenReponse);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password suplied!");
        }
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity refreshToken(String username, String refreshToken){
        var user = repository.findByUsername(username);

        var tokenResponse = new TokenDTO();

        if(user != null){
            tokenResponse = tokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }

        return ResponseEntity.ok(tokenResponse);
    }
}
