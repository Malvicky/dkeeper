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

    @Column(name = "CodeId", unique = true, nullable = false)
    private String CodeId;

    @Column(name = "FirstName", unique = true, nullable = false)
    private String FirstName;

    @Column(name = "LastName", unique = true, nullable = false)
    private String LastName;
}
