package com.pieceofyou.model.client.exceptions.user;

import com.pieceofyou.model.client.exceptions.ApplicationException;

public class InvalidPasswordException extends ApplicationException {
  public InvalidPasswordException() {
    super();
  }

  public InvalidPasswordException(String message) {
    super(message);
  }

  public InvalidPasswordException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidPasswordException(Throwable cause) {
    super(cause);
  }

  public InvalidPasswordException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}