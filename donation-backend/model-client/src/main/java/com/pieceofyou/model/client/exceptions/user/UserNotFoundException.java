package com.pieceofyou.model.client.exceptions.user;

import com.pieceofyou.model.client.exceptions.ApplicationException;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException(String message) {
        super(message);
    }

}
