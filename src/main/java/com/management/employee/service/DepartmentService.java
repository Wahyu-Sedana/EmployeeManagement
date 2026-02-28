package com.management.employee.service;

import com.management.employee.dto.request.CreateDepartmentRequest;
import com.management.employee.dto.response.DepartmentResponse;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    DepartmentResponse create(CreateDepartmentRequest request);

    List<DepartmentResponse> findAll();

    DepartmentResponse findById(UUID id);
}