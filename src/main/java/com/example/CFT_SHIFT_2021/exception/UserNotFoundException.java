package com.example.CFT_SHIFT_2021.exception;

import org.springframework.http.ResponseEntity;

public class UserNotFoundException  extends  Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
