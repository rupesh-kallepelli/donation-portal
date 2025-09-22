package com.pieceofyou.model.client.exceptions.login;

public class InvalidUserPassword extends LoginException {
    public InvalidUserPassword(String message) {
        super(message);
    }
}
