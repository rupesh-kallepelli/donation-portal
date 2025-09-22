package com.pieceofyou.user.service.service;

import org.springframework.http.ResponseEntity;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;

import reactor.core.publisher.Mono;

public interface UserService {
    Mono<ResponseEntity<UserRegistrationResponse>> registerUser(UserRegistrationRequest userDTO);

}