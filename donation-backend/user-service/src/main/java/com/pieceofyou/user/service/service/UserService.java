package com.pieceofyou.user.service.service;

import com.pieceofyou.model.client.userservice.UserDTO;

import reactor.core.publisher.Mono;

public interface UserService {
    Mono<String> registerUser(UserDTO userDTO);

}