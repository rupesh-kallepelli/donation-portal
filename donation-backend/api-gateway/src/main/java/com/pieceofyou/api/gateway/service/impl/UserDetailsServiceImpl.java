package com.pieceofyou.api.gateway.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pieceofyou.api.gateway.service.UserDetailService;
import com.pieceofyou.api.gateway.service.UserService;

import reactor.core.publisher.Mono;

@Service
public class UserDetailsServiceImpl implements UserDetailService {
  private UserService userService;

  public UserDetailsServiceImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public Mono<UserDetails> findByUsername(String username) {
    return userService.findByUserEmail(username)
        .map(user -> User.withUsername(user.getUsername()).password(user.getPassword()).build());
  }

}
