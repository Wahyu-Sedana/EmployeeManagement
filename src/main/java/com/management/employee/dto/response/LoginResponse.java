package com.management.employee.dto.response;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private UUID id;
    private String username;
    private String email;
    private String token;
}
