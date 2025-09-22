package com.pieceofyou.model.client.exceptions.server;

import java.util.List;

import com.pieceofyou.model.client.exceptions.ApplicationException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServerSideException extends ApplicationException {
  private final Integer statusCode;
  private final List<String> responseMessages;

  public ServerSideException(String message, Integer statusCode) {
    super(message);
    this.statusCode = statusCode;
    responseMessages = List.of();
  }

  public ServerSideException(String message, Throwable cause, Integer statusCode) {
    super(message, cause);
    this.statusCode = statusCode;
    responseMessages = List.of();
  }

  public ServerSideException(String message, Integer statusCode, List<String> responseMessages) {
    super(message);
    this.statusCode = statusCode;
    this.responseMessages = responseMessages;
  }

  public ServerSideException(String message, Throwable cause, Integer statusCode, List<String> responseMessages) {
    super(message, cause);
    this.statusCode = statusCode;
    this.responseMessages = responseMessages;
  }

}
