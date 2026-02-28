package com.management.employee.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.employee.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, UUID> {
    
    Optional<Auth> findByEmail(String email);
}
