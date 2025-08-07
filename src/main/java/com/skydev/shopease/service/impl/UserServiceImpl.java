package com.skydev.shopease.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skydev.shopease.dto.request.auth.AuthRequest;
import com.skydev.shopease.dto.request.auth.RegisterRequest;
import com.skydev.shopease.dto.response.AuthResponse;
import com.skydev.shopease.entity.Role;
import com.skydev.shopease.entity.User;
import com.skydev.shopease.enums.UserRole;
import com.skydev.shopease.repository.RoleRepository;
import com.skydev.shopease.repository.UserRepository;
import com.skydev.shopease.service.JwtService;
import com.skydev.shopease.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    /**
     * Enregistre un nouvel utilisateur
     */
    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByName(request.getName())) {
            throw new RuntimeException("Name already taken");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already used");
        }

        Role customerRole = roleRepository.findByName(UserRole.CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(customerRole)) // 👈 à adapter selon ta logique (CUSTOMER, ADMIN, etc.)
                .build();

        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .roles(user.getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toSet()))
                .build();

    }

    @Override
    public AuthResponse login(AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (AuthenticationException e) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }
        User user = this.getUserByEmail(request.getEmail());
        // 🔐 Ajout des rôles comme claims dans le token
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", user.getRoles().stream()
                .map(role -> "ROLE_" + role.getName().name()) // important de garder le préfixe ROLE_
                .collect(Collectors.toList()));
        String token = jwtService.generateToken(claims, user);
        return AuthResponse.builder()
                .token(token)
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .roles(user.getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toSet()))
                .build();
    }

    /**
     * Chargement d’un utilisateur pour Spring Security
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByEmail(name)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + name));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
