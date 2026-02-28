package com.management.employee.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PositionResponse {

    private UUID id;
    private String name;
    private String description;
    private String departmentName;
}