package com.management.employee.controller;

import com.management.employee.dto.request.CreateEmployeeRequest;
import com.management.employee.dto.response.ApiResponse;
import com.management.employee.dto.response.EmployeeResponse;
import com.management.employee.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> create(
            @Valid @RequestBody CreateEmployeeRequest request
    ) {

        EmployeeResponse response = employeeService.create(request);

        return ResponseEntity.ok(
                ApiResponse.<EmployeeResponse>builder()
                        .status(200)
                        .message("Employee created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> findAll() {

        List<EmployeeResponse> response = employeeService.findAll();

        return ResponseEntity.ok(
                ApiResponse.<List<EmployeeResponse>>builder()
                        .status(200)
                        .message("Employees retrieved successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> findById(
            @PathVariable UUID id
    ) {

        EmployeeResponse response = employeeService.findById(id);

        return ResponseEntity.ok(
                ApiResponse.<EmployeeResponse>builder()
                        .status(200)
                        .message("Employee retrieved successfully")
                        .data(response)
                        .build()
        );
    }
}