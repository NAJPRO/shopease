package com.skydev.shopease.mapper;

import org.mapstruct.Mapper;

import com.skydev.shopease.dto.request.UserRequestDTO;
import com.skydev.shopease.dto.response.UserResponseDTO;
import com.skydev.shopease.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO dto);
    UserResponseDTO toDto(User entity);
}
