package com.skydev.shopease.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.skydev.shopease.entity.Role;
import com.skydev.shopease.enums.UserRole;
import com.skydev.shopease.repository.RoleRepository;

@Component
public class RoleSeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findAll().isEmpty()) {
            Role userRole = new Role();
            userRole.setName(UserRole.CUSTOMER);

            Role adminRole = new Role();
            adminRole.setName(UserRole.ADMIN);

            roleRepository.saveAll(List.of(userRole, adminRole));
            System.out.println("✅ Rôles créés avec succès");
        }
    }
}
