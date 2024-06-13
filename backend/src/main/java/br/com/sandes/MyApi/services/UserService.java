package br.com.sandes.MyApi.services;

import br.com.sandes.MyApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("User "+ username + " was found by name!");

        var user = repository.findByUsername(username);

        if(username != null){
            return user;
        }
        else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
    }
}
