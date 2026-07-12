package com.devhub.backend.modules.auth.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BusinessException{

    public InvalidCredentialsException(){
        super("Invalid Credential", HttpStatus.UNAUTHORIZED);
    }
}
