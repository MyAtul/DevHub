package com.devhub.backend.common.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BusinessException{

    public InvalidCredentialsException(){
        super("Invalid Credential", HttpStatus.UNAUTHORIZED);
    }
}
