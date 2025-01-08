package com.dkeeper.dkeeper.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ServiceProvidedDto {
    @Column(name = "code_id", unique = true, nullable = false)
    private String codeId;

    @Column(name = "employee_id", unique = true, nullable = false)
    private String employeeId;

    @Column(name = "service_provided", unique = true, nullable = false)
    private String serviceProvided;

    @Column(name = "price_final", unique = true, nullable = false)
    private String priceFinal;
}