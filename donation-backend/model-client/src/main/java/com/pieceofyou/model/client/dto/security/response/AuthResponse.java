package com.pieceofyou.model.client.dto.security.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pieceofyou.model.client.response.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse  extends Response{
    private String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

}