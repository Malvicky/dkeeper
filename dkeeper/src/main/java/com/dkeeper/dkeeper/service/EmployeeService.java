package com.dkeeper.dkeeper.service;
import com.dkeeper.dkeeper.dto.EmployeeDto;
import com.dkeeper.dkeeper.model.Employee;
import com.dkeeper.dkeeper.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public String addEmployee(EmployeeDto load){
        Employee employee = new Employee();
        employee.setEmployeeId(load.getEmployeeId());
        employee.setEmployeeFirstname(load.getEmployeeFirstname());
        employee.setEmployeeLastname(load.getEmployeeLastname());
        employee.setEmployeeContact( load.getEmployeeContact());
        employeeRepository.save(employee);
        return "Stay Safe";
    }
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            // Convert Employee to EmployeeDto
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setEmployeeId(employee.getEmployeeId());
            employeeDto.setEmployeeFirstname(employee.getEmployeeFirstname());
            employeeDto.setEmployeeLastname(employee.getEmployeeLastname());
            employeeDto.setEmployeeContact(employee.getEmployeeContact());
            return employeeDto;
        } else {
            return null; // or throw an exception if preferred
        }
    }
    public String updateEmployee(Long employeeId, EmployeeDto load) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setEmployeeFirstname(load.getEmployeeFirstname());
            employee.setEmployeeLastname(load.getEmployeeLastname());
            employee.setEmployeeContact(load.getEmployeeContact());
            employeeRepository.save(employee);
            return "Employee updated successfully";
        } else {
            return "Employee not found";
        }
    }

    public String deleteEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return "Employee deleted successfully";
        } else {
            return "Employee not found";
        }
    }}