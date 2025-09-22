package com.pieceofyou.model.client.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Response {
  private List<String> messages;
  private Integer statusCode;

  public Response(List<String> messages, Integer statusCode) {
    this.messages = messages;
    this.statusCode = statusCode;
  }
}
