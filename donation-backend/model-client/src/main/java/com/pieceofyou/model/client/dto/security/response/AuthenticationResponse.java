package com.pieceofyou.model.client.dto.security.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pieceofyou.model.client.response.Response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class AuthenticationResponse extends Response{
    private String jwt;
    private String errorResponse;
}
