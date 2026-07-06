package com.devhub.backend.common.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends BusinessException{

    public EmailAlreadyExistsException(){
       super("Email Already Exists",HttpStatus.CONFLICT);
    }
}
