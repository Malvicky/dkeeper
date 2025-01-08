package com.dkeeper.dkeeper.dto;

import lombok.Data;

import javax.persistence.Column;

@Data

public class ScheduleDto {
    @Column(name = "code_id", unique = true, nullable = false)
    private String codeId;

    @Column(name = "employee_id", unique = true, nullable = false)
    private String employeeId;

    @Column(name = "location", unique = true, nullable = false)
    private String location;
}
