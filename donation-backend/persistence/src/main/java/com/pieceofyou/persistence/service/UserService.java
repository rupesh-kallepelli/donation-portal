package com.pieceofyou.persistence.service;

import com.pieceofyou.model.client.userservice.UserDTO;

public interface UserService {
    void createUser(UserDTO userDTO);
    // void activateUser(Long userId);
    // void getUserById(Long userId);
}