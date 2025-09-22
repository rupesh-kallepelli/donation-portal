package com.pieceofyou.api.gateway.service;

import org.springframework.http.ResponseEntity;

import com.pieceofyou.model.client.dto.security.request.AuthenticationRequest;
import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.AuthenticationResponse;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.model.client.dto.security.response.UserVerificationResponse;
import com.pieceofyou.model.client.dto.user.CustomUserDetails;

import reactor.core.publisher.Mono;

public interface UserService {
  Mono<Boolean> isUserExistsWithEmailAddress(String email);

  Mono<ResponseEntity<UserRegistrationResponse>> registerUser(UserRegistrationRequest userDTO);

  Mono<ResponseEntity<UserVerificationResponse>> verifyUser(String verificationKey);

  Mono<ResponseEntity<UserVerificationResponse>> resendVerificationTokenFor(String userName);

  Mono<Boolean> isUserExistsWithMobileNumber(String ext, String mobile);

  Mono<ResponseEntity<AuthenticationResponse>> createJwtToken(AuthenticationRequest authenticationRequest);
  Mono<CustomUserDetails> findByUserEmail(String username);
}
