package com.management.employee.service.impl;

import com.management.employee.dto.request.CreatePositionRequest;
import com.management.employee.dto.response.PositionResponse;
import com.management.employee.entity.Department;
import com.management.employee.entity.Position;
import com.management.employee.mapper.PositionMapper;
import com.management.employee.repository.DepartmentRepository;
import com.management.employee.repository.PositionRepository;
import com.management.employee.service.PositionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public PositionResponse create(CreatePositionRequest request) {

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow();

        Position position = new Position();

        position.setName(request.getName());
        position.setDescription(request.getDescription());
        position.setDepartment(department);

        positionRepository.save(position);

        return PositionMapper.toResponse(position);
    }

    @Override
    public List<PositionResponse> findAll() {

        return positionRepository.findAll()
                .stream()
                .map(PositionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PositionResponse findById(UUID id) {

        Position position = positionRepository.findById(id)
                .orElseThrow();

        return PositionMapper.toResponse(position);
    }
}