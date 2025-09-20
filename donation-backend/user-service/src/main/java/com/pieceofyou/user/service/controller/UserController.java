package com.pieceofyou.user.service.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pieceofyou.model.client.userservice.UserDTO;
import com.pieceofyou.user.service.service.UserService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String getMethodName() {
        return "Hello from User Service";
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<Map<String, String>>> registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO)
            .doOnSuccess(res -> log.info("User registered successfully: {} ", userDTO))
            .thenReturn(ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully")))
            .onErrorResume(entity -> {
                log.error("Error while registering user", entity);
                return Mono.just(new ResponseEntity<>(Collections.singletonMap("message", "User registration failed"), HttpStatus.CONFLICT));
            });
    }

}
