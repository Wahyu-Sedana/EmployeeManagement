package com.management.employee.mapper;

import com.management.employee.dto.response.LoginResponse;
import com.management.employee.entity.Auth;

public class AuthMapper {

    public static LoginResponse toLoginResponse(Auth admin) {

        LoginResponse response = new LoginResponse();
        response.setId(admin.getId());
        response.setUsername(admin.getUsername());
        response.setEmail(admin.getEmail());
        return response;
    }    
}
