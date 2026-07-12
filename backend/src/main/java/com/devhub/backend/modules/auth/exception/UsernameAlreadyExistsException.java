package com.devhub.backend.modules.auth.exception;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistsException extends BusinessException{

    public UsernameAlreadyExistsException(){
        super("Username Already Exists",HttpStatus.CONFLICT);
    }
}
