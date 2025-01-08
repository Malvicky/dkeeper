package com.dkeeper.dkeeper.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", unique = true, nullable = false)
    private String employeeId;

    @Column(name = "employee_firstname", unique = true, nullable = false)
    private String employeeFirstname;

    @Column(name = "employee_lastname", unique = true, nullable = false)
    private String employeeLastname;

    @Column(name = "employee_contact", unique = true, nullable = false)
    private String employeeContact;

}
