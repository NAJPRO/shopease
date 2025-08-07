package com.skydev.shopease.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.skydev.shopease.entity.Role;
import com.skydev.shopease.entity.User;
import com.skydev.shopease.enums.UserRole;
import com.skydev.shopease.repository.RoleRepository;
import com.skydev.shopease.repository.UserRepository;
import com.skydev.shopease.service.UserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RoleSeeder implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findAll().isEmpty()) {
            Role userRole = new Role();
            userRole.setName(UserRole.CUSTOMER);

            Role adminRole = new Role();
            adminRole.setName(UserRole.ADMIN);

            roleRepository.saveAll(List.of(userRole, adminRole));
            System.out.println("Rôles créés avec succès");

            User user = User.builder()
                .name("Audin Junior")
                .email("admin@gmail.com")
                .phone("68930383736")
                .password(passwordEncoder.encode("password"))
                .build();

            userRepository.save(user);
        }
    }
}
