package com.pieceofyou.model.client.exceptions.registration;

import java.util.List;

import com.pieceofyou.model.client.exceptions.ApplicationException;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAlreadyExistsException extends ApplicationException {
  private final List<String> responseMessages;

  public UserAlreadyExistsException(String message) {
    super(message);
    responseMessages = List.of(message);
  }

  public UserAlreadyExistsException(String exceptionMessage, @NotNull List<String> responseMessages) {
    super(exceptionMessage);
    this.responseMessages = responseMessages;
  }

}
