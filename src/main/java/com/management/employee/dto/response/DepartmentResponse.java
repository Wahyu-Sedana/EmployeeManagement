package com.management.employee.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DepartmentResponse {

    private UUID id;
    private String name;
    private String description;
}