package com.pieceofyou.model.client.exceptions.login;

public class UserNotFoundException extends LoginException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
