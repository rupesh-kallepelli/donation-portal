package com.pieceofyou.persistence.service.impl;

import org.springframework.stereotype.Service;

import com.pieceofyou.model.client.userservice.UserDTO;
import com.pieceofyou.persistence.mapper.UserMapper;
import com.pieceofyou.persistence.repository.UserRepository;
import com.pieceofyou.persistence.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userRepository.save(userMapper.toEntity(userDTO));
    }

}