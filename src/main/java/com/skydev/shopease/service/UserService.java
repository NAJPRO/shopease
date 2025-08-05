package com.skydev.shopease.service;

import com.skydev.shopease.dto.request.auth.AuthRequest;
import com.skydev.shopease.dto.request.auth.RegisterRequest;
import com.skydev.shopease.dto.response.AuthResponse;
import com.skydev.shopease.entity.User;

public interface UserService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(AuthRequest request);

    User getUserByEmail(String email);
}
