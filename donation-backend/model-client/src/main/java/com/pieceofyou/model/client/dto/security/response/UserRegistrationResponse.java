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
  private List<String> messages;
  private Integer statusCode;

  public UserRegistrationResponse(List<String> messages, Integer statusCode) {
    super(messages, statusCode);
    this.messages = messages;
    this.statusCode = statusCode;
  }
}
