package com.dkeeper.dkeeper.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ServiceProvidedDto {
    @Column(name = "CodeId", unique = true, nullable = false)
    private String CodeId;

    @Column(name = "ServiceId", unique = true, nullable = false)
    private String ServiceId;

    @Column(name = "PriceFinal", unique = true, nullable = false)
    private String PriceFinal;
}
