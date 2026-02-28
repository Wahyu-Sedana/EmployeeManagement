package com.management.employee.mapper;

import com.management.employee.dto.response.EmployeeResponse;
import com.management.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeResponse toResponse(Employee employee) {

        EmployeeResponse response = new EmployeeResponse();

        response.setId(employee.getId());
        response.setEmployeeCode(employee.getEmployeeCode());
        response.setFullName(
            employee.getFirstName() + " " + employee.getLastName()
        );
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        response.setHireDate(employee.getHireDate());
        response.setSalary(employee.getSalary());

        response.setDepartmentName(
            employee.getDepartment().getName()
        );

        response.setPositionName(
            employee.getPosition().getName()
        );

        return response;
    }
}