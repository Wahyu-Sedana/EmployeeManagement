package com.management.employee.service.impl;

import com.management.employee.dto.request.LoginRequest;
import com.management.employee.dto.response.LoginResponse;
import com.management.employee.entity.Auth;
import com.management.employee.repository.AuthRepository;
import com.management.employee.security.JWTUtils;
import com.management.employee.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final JWTUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    @Override
    public LoginResponse login(LoginRequest request) {

        Auth admin = authRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtils.generateToken(admin.getId(), admin.getEmail());

        LoginResponse response = new LoginResponse();
        response.setId(admin.getId());
        response.setUsername(admin.getUsername());
        response.setEmail(admin.getEmail());
        response.setToken(token);

        return response;
    }
}