package com.skydev.shopease.mapper;

import org.mapstruct.Mapper;

import com.skydev.shopease.dto.response.UserResponse;
import com.skydev.shopease.entity.User;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    UserResponse toResponse(User user);

}
