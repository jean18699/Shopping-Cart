package com.personal.shop.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
