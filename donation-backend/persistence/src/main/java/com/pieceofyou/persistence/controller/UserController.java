package com.pieceofyou.persistence.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.model.client.exceptions.registration.RegistrationException;
import com.pieceofyou.model.client.exceptions.registration.UserAlreadyExistsException;
import com.pieceofyou.persistence.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody @Valid UserRegistrationRequest userDTO) {
        try {
            log.info("Registering user: {} ", userDTO);
            UserRegistrationResponse response = userService.registerUser(userDTO);
            log.info("User registered successfully: {} ", userDTO);
            return ResponseEntity.ok(response);
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            log.error("Error while registering user {}", userAlreadyExistsException.getResponseMessages());
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new UserRegistrationResponse(userAlreadyExistsException.getResponseMessages(),
                            HttpStatus.CONFLICT.value()));
        } catch (RegistrationException registrationException) {
            log.error("Error while registering user {}", registrationException.getResponseMessages());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new UserRegistrationResponse(registrationException.getResponseMessages(),
                            HttpStatus.BAD_REQUEST.value()));
        } catch (Exception exception) {
            log.error("Unexpected error while registering user {}", exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new UserRegistrationResponse(List.of("An unexpected error occurred. Please try again later."),
                            HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

}
