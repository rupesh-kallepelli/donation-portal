package com.pieceofyou.api.gateway.serviceproxy.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pieceofyou.api.gateway.serviceproxy.UserServiceProxy;
import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.model.client.dto.security.response.UserVerificationResponse;

import reactor.core.publisher.Mono;

@Service
public class UserServiceProxyImpl implements UserServiceProxy {

  @Override
  public Mono<ResponseEntity<UserRegistrationResponse>> registerUser(UserRegistrationRequest userDTO) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
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
