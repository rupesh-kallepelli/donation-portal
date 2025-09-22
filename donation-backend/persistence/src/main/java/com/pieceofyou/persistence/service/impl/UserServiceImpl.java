package com.pieceofyou.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;
import com.pieceofyou.model.client.exceptions.registration.RegistrationException;
import com.pieceofyou.model.client.exceptions.registration.UserAlreadyExistsException;
import com.pieceofyou.persistence.entity.User;
import com.pieceofyou.persistence.mapper.UserMapper;
import com.pieceofyou.persistence.repository.UserRepository;
import com.pieceofyou.persistence.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRegistrationResponse registerUser(UserRegistrationRequest userDTO) {
        if (null == userDTO) {
            throw new RegistrationException("User data cannot be null");
        }
        User user = validateUserDTO(userDTO);
        log.info("Validated user data: {} ", user);
        userRepository.save(user);

        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setMessages(
                List.of("User registered successfully",
                        "Please check your email to activate your account."));
        response.setUserName(userDTO.getName());
        return response;
    }

    private User validateUserDTO(UserRegistrationRequest userDTO) {
        List<String> messages = new ArrayList<>();

        if (userDTO.getName() == null || userDTO.getName().isBlank()) {
            messages.add("Name is required.");
        }
        if (userDTO.getEmail() == null || userDTO.getEmail().isBlank()) {
            messages.add("Email is required.");
        } else if (!userDTO.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            messages.add("Email format is invalid.");
        }
        if (userDTO.getPassword() == null || userDTO.getPassword().isBlank()) {
            messages.add("Password is required.");
        } else if (userDTO.getPassword().length() < 6) {
            messages.add("Password must be at least 6 characters long.");
        }
        log.info("Validation messages: {} ", messages);
        if (!messages.isEmpty()) {
            throw new RegistrationException("Invalid user data: " + String.join(", ", messages));
        }
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserAlreadyExistsException("Email is already in use.");
        }
        return userMapper.toEntity(userDTO);
    }
}