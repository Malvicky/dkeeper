package com.dkeeper.dkeeper.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schedule")
@Data
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_id", unique = true, nullable = false)
    private String codeId;

    @Column(name = "employee_id", unique = true, nullable = false)
    private String employeeId;

    @Column(name = "location", unique = true, nullable = false)
    private String location;
}
