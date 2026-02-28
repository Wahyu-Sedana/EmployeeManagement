package com.management.employee.repository;

import com.management.employee.entity.Position;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, UUID> {

}