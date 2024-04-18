package com.dkeeper.dkeeper.service;
import com.dkeeper.dkeeper.dto.EmployeeDto;
import com.dkeeper.dkeeper.model.Employee;
import com.dkeeper.dkeeper.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

public String addEmployee(EmployeeDto load){
    Employee employee = new Employee();
    employee.setCodeId(load.getCodeId());
    employee.setFirstName(load.getFirstName());
    employee.setLastName(load.getLastName());
    employeeRepository.save(employee);
    return "Stay Safe";
}
}
