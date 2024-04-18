package com.dkeeper.dkeeper.dto;
import lombok.Data;
import javax.persistence.Column;
@Data
public class EmployeeDto {
    @Column(name = "CodeId", unique = true, nullable = false)
    private String CodeId;

    @Column(name = "FirstName", unique = true, nullable = false)
    private String FirstName;

    @Column(name = "LastName", unique = true, nullable = false)
    private String LastName;
}
