package com.management.employee.service;

import com.management.employee.dto.request.LoginRequest;
import com.management.employee.dto.response.LoginResponse;

public interface AuthService {
     LoginResponse login(LoginRequest request);
}
