package com.skydev.shopease.dto.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
   private Long id;
    private String name;
    private String email;
    private String phone;
    // private Set<String> roles;
}
