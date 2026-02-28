package com.management.employee.controller;

import com.management.employee.dto.request.CreateDepartmentRequest;
import com.management.employee.dto.response.ApiResponse;
import com.management.employee.dto.response.DepartmentResponse;
import com.management.employee.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentResponse>> create(
            @Valid @RequestBody CreateDepartmentRequest request
    ) {

        DepartmentResponse response = departmentService.create(request);

        return ResponseEntity.ok(
                ApiResponse.<DepartmentResponse>builder()
                        .status(200)
                        .message("Department created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentResponse>>> findAll() {

        List<DepartmentResponse> response = departmentService.findAll();

        return ResponseEntity.ok(
                ApiResponse.<List<DepartmentResponse>>builder()
                        .status(200)
                        .message("Departments retrieved successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponse>> findById(
            @PathVariable UUID id
    ) {

        DepartmentResponse response = departmentService.findById(id);

        return ResponseEntity.ok(
                ApiResponse.<DepartmentResponse>builder()
                        .status(200)
                        .message("Department retrieved successfully")
                        .data(response)
                        .build()
        );
    }
}