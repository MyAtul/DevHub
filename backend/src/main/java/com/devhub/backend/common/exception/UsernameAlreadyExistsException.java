package com.devhub.backend.common.exception;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistsException extends BusinessException{

    public UsernameAlreadyExistsException(){
        super("Username Already Exists",HttpStatus.CONFLICT);
    }
}
