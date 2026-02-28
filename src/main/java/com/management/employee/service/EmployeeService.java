package com.management.employee.service;

import com.management.employee.dto.request.CreateEmployeeRequest;
import com.management.employee.dto.response.EmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    EmployeeResponse create(CreateEmployeeRequest request);

    List<EmployeeResponse> findAll();

    EmployeeResponse findById(UUID id);
}