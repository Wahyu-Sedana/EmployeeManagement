package com.management.employee.service.impl;

import com.management.employee.dto.request.CreateDepartmentRequest;
import com.management.employee.dto.response.DepartmentResponse;
import com.management.employee.entity.Department;
import com.management.employee.mapper.DepartmentMapper;
import com.management.employee.repository.DepartmentRepository;
import com.management.employee.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse create(CreateDepartmentRequest request) {

        Department department = new Department();

        department.setName(request.getName());
        department.setDescription(request.getDescription());

        departmentRepository.save(department);

        return DepartmentMapper.toResponse(department);
    }

    @Override
    public List<DepartmentResponse> findAll() {

        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse findById(UUID id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow();

        return DepartmentMapper.toResponse(department);
    }
}