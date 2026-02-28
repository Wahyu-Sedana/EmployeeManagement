package com.management.employee.service;

import com.management.employee.dto.request.CreatePositionRequest;
import com.management.employee.dto.response.PositionResponse;

import java.util.List;
import java.util.UUID;

public interface PositionService {

    PositionResponse create(CreatePositionRequest request);

    List<PositionResponse> findAll();

    PositionResponse findById(UUID id);
}