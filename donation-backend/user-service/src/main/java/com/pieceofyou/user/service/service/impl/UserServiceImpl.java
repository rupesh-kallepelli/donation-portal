package com.pieceofyou.user.service.service.impl;

import org.springframework.stereotype.Service;

import com.pieceofyou.model.client.userservice.UserDTO;
import com.pieceofyou.user.service.service.UserService;
import com.pieceofyou.user.service.serviceproxy.UserServiceProxy;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
    private final UserServiceProxy userServiceProxy;

    public UserServiceImpl(UserServiceProxy userServiceProxy) {
        this.userServiceProxy = userServiceProxy;
    }

    public Mono<String> registerUser(UserDTO userDTO) {
        return userServiceProxy.registerUser(userDTO);
    }
}
