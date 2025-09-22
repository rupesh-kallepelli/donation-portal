package com.pieceofyou.api.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.pieceofyou.api.gateway.service.UserService;
import com.pieceofyou.model.client.dto.security.request.AuthenticationRequest;
import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.AuthenticationResponse;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.model.client.dto.security.response.UserVerificationResponse;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserService userService;

    public AuthController( UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public Mono<ResponseEntity<UserRegistrationResponse>> registerUser(
            @RequestBody @Valid UserRegistrationRequest registrationRequest) {
        return userService.registerUser(registrationRequest);
    }

    @PostMapping("login")
    public Mono<ResponseEntity<AuthenticationResponse>> login(
            @RequestBody @Valid AuthenticationRequest authenticationRequest, ServerWebExchange exchange) {
        String remoteAddr = exchange.getRequest().getHeaders().getFirst("X-Forwarded-For");
        log.debug("Logged in User Ip : {}", remoteAddr);
        return userService.createJwtToken(authenticationRequest);
    }

    @GetMapping("verify")
    public Mono<ResponseEntity<UserVerificationResponse>> verifyUser(@RequestParam String key) {
        return userService.verifyUser(key);
    }

    @PostMapping("verify/resend")
    public Mono<ResponseEntity<UserVerificationResponse>> resendVerificationToke(
            @RequestParam @Nonnull String username) {
        return userService.resendVerificationTokenFor(username);
    }

}