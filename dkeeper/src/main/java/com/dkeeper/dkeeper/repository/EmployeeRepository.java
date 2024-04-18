package com.dkeeper.dkeeper.repository;

import com.dkeeper.dkeeper.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
