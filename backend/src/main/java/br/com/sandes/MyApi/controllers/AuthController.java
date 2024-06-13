package br.com.sandes.MyApi.controllers;

import br.com.sandes.MyApi.data.dto.v1.security.AccountCredentialsDTO;
import br.com.sandes.MyApi.services.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Authentication Endpoint")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService service;

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/signin",
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity signin(@RequestBody AccountCredentialsDTO data){
        if(checkIfParamsIsNotNull(data)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Invalid client request");
        }

        var token = service.signing(data);

        if(token == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Invalid client request");
        }

        return ResponseEntity.ok(token);
    }

    @SuppressWarnings("rawtypes")
    @PutMapping(value = "/refresh/{username}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity refreshToken(
            @PathVariable ("username") String username,
            @RequestHeader("Authorization") String refreshToken){

        if(checkIfParamsIsNotNull(username, refreshToken)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Invalid client request");
        }

        var token = service.refreshToken(username, refreshToken);

        if(token == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Invalid client request");
        }
        
        return ResponseEntity.ok(token);
    }

    private boolean checkIfParamsIsNotNull(String username, String refreshToken) {
        return refreshToken == null || refreshToken.isBlank() ||
                username == null || refreshToken.isBlank();
    }

    private boolean checkIfParamsIsNotNull(AccountCredentialsDTO data) {
        return data == null ||
                data.getUsername() == null ||
                data.getUsername().isBlank() ||
                data.getPassword() == null ||
                data.getPassword().isBlank();
    }
}
