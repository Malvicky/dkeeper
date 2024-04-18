package com.dkeeper.dkeeper.dto;

import lombok.Data;

import javax.persistence.Column;

@Data

public class ScheduleDto {
    @Column(name = "CodeId", unique = true, nullable = false)
    private String CodeId;

    @Column(name = "EmployeeId", unique = true, nullable = false)
    private String EmployeeId;

    @Column(name = "Location", unique = true, nullable = false)
    private String Location;
}
