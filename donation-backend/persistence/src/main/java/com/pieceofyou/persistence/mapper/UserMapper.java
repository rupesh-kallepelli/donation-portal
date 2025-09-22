package com.pieceofyou.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.persistence.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRegistrationRequest toDto(User user);

    User toEntity(UserRegistrationRequest userDTO);
}
