package com.management.employee.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

    private UUID id;
    private String employeeCode;
    private String fullName;
    private String email;
    private String phone;
    private BigDecimal salary;
    private LocalDate hireDate;
    private String departmentName;
    private String positionName;

}