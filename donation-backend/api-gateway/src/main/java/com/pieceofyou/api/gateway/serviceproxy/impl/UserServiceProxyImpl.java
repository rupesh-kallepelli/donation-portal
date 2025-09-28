package com.pieceofyou.api.gateway.serviceproxy.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pieceofyou.api.gateway.serviceproxy.UserServiceProxy;
import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.model.client.dto.security.response.UserVerificationResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserServiceProxyImpl implements UserServiceProxy {
  private WebClient userServiceWebClient;

  public UserServiceProxyImpl(WebClient userServiceWebClient) {
    this.userServiceWebClient = userServiceWebClient;
  }

  @Override
  public Mono<ResponseEntity<UserRegistrationResponse>> registerUser(UserRegistrationRequest userDTO) {
    return userServiceWebClient.post()
        .uri("/api/user/register")
        .bodyValue(userDTO)
        .exchangeToMono(response -> response.bodyToMono(UserRegistrationResponse.class)
            .map(userRegistrationResponse -> {
              log.info("Received response from user service: {}", userRegistrationResponse);
              return ResponseEntity.status(response.statusCode())
                  .body(userRegistrationResponse);
            }));
  }

  @Override
  public Mono<Boolean> findByUserEmail(String username) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByUserEmail'");
  }

  @Override
  public Mono<ResponseEntity<UserVerificationResponse>> verifyUser(String verificationKey) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'verifyUser'");
  }

  @Override
  public Mono<ResponseEntity<UserVerificationResponse>> resendVerificationTokenFor(String username) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'resendVerificationTokenFor'");
  }

}
