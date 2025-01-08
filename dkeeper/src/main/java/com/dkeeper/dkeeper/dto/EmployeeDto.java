package com.dkeeper.dkeeper.dto;
import lombok.Data;
import javax.persistence.Column;
@Data
public class EmployeeDto {
    @Column(name = "employee_id", unique = true, nullable = false)
    private String employeeId;

    @Column(name = "employee_firstname", unique = true, nullable = false)
    private String employeeFirstname;

    @Column(name = "employee_lastname", unique = true, nullable = false)
    private String employeeLastname;

    @Column(name = "employee_contact", unique = true, nullable = false)
    private String employeeContact;

}
