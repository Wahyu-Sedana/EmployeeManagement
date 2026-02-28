package com.management.employee.mapper;

import com.management.employee.dto.response.PositionResponse;
import com.management.employee.entity.Position;

public class PositionMapper {

    public static PositionResponse toResponse(Position position) {

        PositionResponse response = new PositionResponse();

        response.setId(position.getId());
        response.setName(position.getName());
        response.setDescription(position.getDescription());
        response.setDepartmentName(
                position.getDepartment().getName()
        );

        return response;
    }
}