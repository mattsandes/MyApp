package br.com.sandes.MyApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectNullException extends RuntimeException {

    private static final long serivalVersionUID = 1L;

    public RequiredObjectNullException(String message){
        super(message);
    }

    public RequiredObjectNullException(){
        super("It's not allowed to persist a null object!");
    }
}
