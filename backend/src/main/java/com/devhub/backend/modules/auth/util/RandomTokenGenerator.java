package com.devhub.backend.modules.auth.util;

import java.security.SecureRandom;
import java.util.Base64;

public class RandomTokenGenerator {

     private static final SecureRandom SECURE_RANDOM = new SecureRandom();
     private static final int TOKEN_LENGTH = 32;

     public RandomTokenGenerator(){}

    public static String generateToken(){

         byte[] randomBytes = new byte[TOKEN_LENGTH];
         SECURE_RANDOM.nextBytes(randomBytes);

         return Base64.getUrlEncoder()
                 .withoutPadding()
                 .encodeToString(randomBytes);
    }
}
