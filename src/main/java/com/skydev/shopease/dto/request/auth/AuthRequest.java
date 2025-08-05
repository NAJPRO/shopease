package com.skydev.shopease.dto.request.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AuthRequest {
    private String email;
    private String password;
}
