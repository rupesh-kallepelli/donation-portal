package com.pieceofyou.model.client.dto.security.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class AuthenticationRequest {
    @NotBlank(message = "username should not be blank")
    @NotEmpty(message = "username should not be empty")
    @NotNull(message = "username should not be null")
    private String username;
    @NotBlank(message = "password should not be blank")
    @NotEmpty(message = "password should not be empty")
    @NotNull(message = "password should not be null")
    private String password;
}
