package com.pieceofyou.api.gateway.serviceproxy;

import org.springframework.http.ResponseEntity;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.model.client.dto.security.response.UserVerificationResponse;

import reactor.core.publisher.Mono;

public interface UserServiceProxy {
  Mono<ResponseEntity<UserRegistrationResponse>> registerUser(UserRegistrationRequest userDTO);

  Mono<Boolean> findByUserEmail(String username);

  Mono<ResponseEntity<UserVerificationResponse>> verifyUser(String verificationKey);
  Mono<ResponseEntity<UserVerificationResponse>> resendVerificationTokenFor(String username);
}
