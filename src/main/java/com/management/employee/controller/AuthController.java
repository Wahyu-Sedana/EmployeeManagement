package com.management.employee.controller;

import com.management.employee.dto.request.LoginRequest;
import com.management.employee.dto.response.ApiResponse;
import com.management.employee.dto.response.LoginResponse;
import com.management.employee.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request
    ) {
        LoginResponse response = authService.login(request);

        return ResponseEntity.ok(
                ApiResponse.<LoginResponse>builder()
                        .status(200)
                        .message("Login successful")
                        .data(response)
                        .build()
        );
    }
}