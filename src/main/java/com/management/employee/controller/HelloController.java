package com.management.employee.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> hello() {

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello World");
        response.put("status", 200);

        return ResponseEntity.ok(response);
    }
    
}
