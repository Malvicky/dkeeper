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

    @Column(name = "CodeId", unique = true, nullable = false)
    private String CodeId;

    @Column(name = "EmployeeId", unique = true, nullable = false)
    private String EmployeeId;

    @Column(name = "Location", unique = true, nullable = false)
    private String Location;
}
