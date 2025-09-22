package com.pieceofyou.persistence.service;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest userDTO);
    // void activateUser(Long userId);
    // void getUserById(Long userId);
}