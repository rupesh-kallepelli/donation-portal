package com.pieceofyou.model.client.dto.security.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class UserRegistrationRequest {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotBlank(message = "Password is mandatory")
    @NotNull(message = "Password cannot be null")
    private String password;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @NotNull(message = "Email cannot be null")
    private String email;
    @NotBlank(message = "Mobile extension is mandatory")
    @NotNull(message = "Mobile extension cannot be null")
    private String mobileExt;
    @NotBlank(message = "Mobile number is mandatory")
    @NotNull(message = "Mobile number cannot be null")
    @Size(max = 10, message = "Mobile number cannot be longer than 10 digits")
    private String mobile;
    @NotBlank(message = "Blood type is mandatory")
    @NotNull(message = "Blood type cannot be null")
    private String bloodType;
    private boolean organDonor;
    @FutureOrPresent(message = "Created at must be in the present or in the future")
    private LocalDateTime createdAt;
}