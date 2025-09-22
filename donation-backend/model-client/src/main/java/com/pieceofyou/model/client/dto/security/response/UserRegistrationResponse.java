package com.pieceofyou.model.client.dto.security.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pieceofyou.model.client.response.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRegistrationResponse extends Response {
  private String userName;

  public UserRegistrationResponse(List<String> messages, Integer statusCode) {
    super(messages, statusCode);
  }
}
