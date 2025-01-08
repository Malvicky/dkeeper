package com.dkeeper.dkeeper.controller;

import com.dkeeper.dkeeper.dto.EmployeeDto;
import com.dkeeper.dkeeper.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    // Endpoint to add a new employee
    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employeeDto) {
        String response = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Endpoint to update an existing employee
    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto) {
        String response = employeeService.updateEmployee(employeeId, employeeDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint to delete an employee
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        String response = employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint to get an employee by ID
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        // Assuming you have a method in EmployeeService to get an employee by ID
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        if (employeeDto != null) {
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}