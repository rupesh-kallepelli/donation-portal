package com.pieceofyou.api.gateway.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pieceofyou.api.gateway.service.UserService;
import com.pieceofyou.api.gateway.serviceproxy.UserServiceProxy;
import com.pieceofyou.model.client.dto.security.request.AuthenticationRequest;
import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.AuthenticationResponse;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.model.client.dto.security.response.UserVerificationResponse;
import com.pieceofyou.model.client.dto.user.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserServiceProxy userServiceProxy;

  public UserServiceImpl(UserServiceProxy userServiceProxy) {
    this.userServiceProxy = userServiceProxy;
  }

  @Override
  public Mono<ResponseEntity<UserRegistrationResponse>> registerUser(UserRegistrationRequest userRegistrationRequest) {
    return userServiceProxy.registerUser(userRegistrationRequest);
  }

  @Override
  public Mono<ResponseEntity<UserVerificationResponse>> verifyUser(String verificationKey) {
    return userServiceProxy.verifyUser(verificationKey);
  }

  @Override
  public Mono<ResponseEntity<UserVerificationResponse>> resendVerificationTokenFor(String username) {
    return userServiceProxy.resendVerificationTokenFor(username);
  }

  @Override
  public Mono<Boolean> isUserExistsWithEmailAddress(String email) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByUserEmail'");
  }

  @Override
  public Mono<Boolean> isUserExistsWithMobileNumber(String ext, String mobile) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByUserEmail'");
  }

  @Override
  public Mono<ResponseEntity<AuthenticationResponse>> createJwtToken(AuthenticationRequest authenticationRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createJwtToken'");
  }

  @Override
  public Mono<CustomUserDetails> findByUserEmail(String email) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByUserEmail'");
  }
}
