package com.management.employee.mapper;

import com.management.employee.dto.response.DepartmentResponse;
import com.management.employee.entity.Department;

public class DepartmentMapper {

    public static DepartmentResponse toResponse(Department department) {

        DepartmentResponse response = new DepartmentResponse();

        response.setId(department.getId());
        response.setName(department.getName());
        response.setDescription(department.getDescription());

        return response;
    }
}