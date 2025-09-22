package com.pieceofyou.model.client.exceptions;

public class ApplicationException extends RuntimeException {
  public ApplicationException() {
  }

  public ApplicationException(final String message, Throwable cause) {
    super(message);
  }

  public ApplicationException(final String message) {
    super(message);
  }

  public ApplicationException(Throwable cause) {
    super(cause);
  }

  public ApplicationException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
