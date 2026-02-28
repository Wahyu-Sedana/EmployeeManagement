package com.management.employee.controller;

import com.management.employee.dto.request.CreatePositionRequest;
import com.management.employee.dto.response.ApiResponse;
import com.management.employee.dto.response.PositionResponse;
import com.management.employee.service.PositionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/positions")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    public ResponseEntity<ApiResponse<PositionResponse>> create(
            @Valid @RequestBody CreatePositionRequest request
    ) {

        PositionResponse response = positionService.create(request);

        return ResponseEntity.ok(
                ApiResponse.<PositionResponse>builder()
                        .status(200)
                        .message("Position created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PositionResponse>>> findAll() {

        List<PositionResponse> response = positionService.findAll();

        return ResponseEntity.ok(
                ApiResponse.<List<PositionResponse>>builder()
                        .status(200)
                        .message("Positions retrieved successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PositionResponse>> findById(
            @PathVariable UUID id
    ) {

        PositionResponse response = positionService.findById(id);

        return ResponseEntity.ok(
                ApiResponse.<PositionResponse>builder()
                        .status(200)
                        .message("Position retrieved successfully")
                        .data(response)
                        .build()
        );
    }
}