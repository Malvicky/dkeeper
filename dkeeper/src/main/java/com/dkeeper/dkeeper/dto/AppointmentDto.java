package com.dkeeper.dkeeper.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import javax.persistence.Column;
import  java.math.BigDecimal;
import java.time.LocalDateTime;
@Data

public class AppointmentDto {
    @Column(name = "code_id", unique = true, nullable = false)
    private String codeId;

    @Column(name = "end_time", unique = true, nullable = false)
    private LocalDateTime endTime;

    @Column(name = "price_final", unique = true, nullable = false)
    private BigDecimal priceFinal;

    @Column(name = "canceled", unique = true, nullable = false)
    private Boolean canceled;

}