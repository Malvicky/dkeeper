package com.dkeeper.dkeeper.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "service_provided")
public class ServiceProvided {
    @Id
    @Column(name = "code_id", unique = true, nullable = false)
    private String codeId;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "service_provided", nullable = false)
    private String serviceProvided;

    @Column(name = "price_final", nullable = false)
    private String priceFinal;
}