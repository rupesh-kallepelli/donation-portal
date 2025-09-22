package com.pieceofyou.user.service.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.user.service.service.UserService;
import com.pieceofyou.user.service.serviceproxy.UserServiceProxy;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserServiceProxy userServiceProxy;

    public UserServiceImpl(UserServiceProxy userServiceProxy) {
        this.userServiceProxy = userServiceProxy;
    }

    public Mono<ResponseEntity<UserRegistrationResponse>> registerUser(UserRegistrationRequest userDTO) {
        return userServiceProxy.registerUser(userDTO);
    }
}
