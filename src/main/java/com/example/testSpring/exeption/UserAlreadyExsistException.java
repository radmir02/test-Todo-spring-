package com.example.testSpring.exeption;

public class UserAlreadyExsistException extends Exception{
    public UserAlreadyExsistException(String message) {
        super(message);
    }
}
