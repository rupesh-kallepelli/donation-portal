package com.pieceofyou.user.service.service;

import org.springframework.http.ResponseEntity;

import com.pieceofyou.model.client.dto.security.request.AuthenticationRequest;
import com.pieceofyou.model.client.dto.security.response.AuthenticationResponse;

import reactor.core.publisher.Mono;

public interface JwtService {
    Mono<ResponseEntity<AuthenticationResponse>> createJwtToken(AuthenticationRequest authenticationRequest);
}
