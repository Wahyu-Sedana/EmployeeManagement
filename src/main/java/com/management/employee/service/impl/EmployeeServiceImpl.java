package com.management.employee.service.impl;

import com.management.employee.dto.request.CreateEmployeeRequest;
import com.management.employee.dto.response.EmployeeResponse;
import com.management.employee.entity.Department;
import com.management.employee.entity.Employee;
import com.management.employee.entity.Position;
import com.management.employee.mapper.EmployeeMapper;
import com.management.employee.repository.DepartmentRepository;
import com.management.employee.repository.EmployeeRepository;
import com.management.employee.repository.PositionRepository;
import com.management.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    @Override
    public EmployeeResponse create(CreateEmployeeRequest request) {

        System.out.println("Salary: " + request.getSalary());

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow();

        Position position = positionRepository.findById(request.getPositionId())
                .orElseThrow();

        Employee employee = new Employee();

        employee.setEmployeeCode(request.getEmployeeCode());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setHireDate(request.getHireDate());
        employee.setDepartment(department);
        employee.setPosition(position);

        employeeRepository.save(employee);

        return EmployeeMapper.toResponse(employee);
    }

    @Override
    public List<EmployeeResponse> findAll() {

        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse findById(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow();

        return EmployeeMapper.toResponse(employee);
    }
}