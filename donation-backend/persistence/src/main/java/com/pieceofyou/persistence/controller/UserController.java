package com.pieceofyou.persistence.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pieceofyou.model.client.userservice.UserDTO;
import com.pieceofyou.persistence.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            userService.createUser(userDTO);
            log.info("User registered successfully: {} ", userDTO);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception entity) {
            log.error("Error while registering user", entity);
            return ResponseEntity.internalServerError().body(entity.getMessage());
        }

    }

}
