package com.pieceofyou.model.client.dto.security.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pieceofyou.model.client.response.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVerificationResponse  extends Response {
    private String message;
}
