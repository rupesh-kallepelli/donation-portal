package com.pieceofyou.persistence.mapper;

import com.pieceofyou.model.client.userservice.UserDTO;
import com.pieceofyou.persistence.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}
