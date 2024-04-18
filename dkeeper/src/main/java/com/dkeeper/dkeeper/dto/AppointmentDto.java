package com.dkeeper.dkeeper.dto;
import lombok.Data;
import javax.persistence.Column;
@Data
public class AppointmentDto {
    @Column(name = "CodeId", unique = true, nullable = false)
    private String CodeId;

    @Column(name = "ClientID", unique = true, nullable = false)
    private String ClientID;

    @Column(name = "ClientName", unique = true, nullable = false)
    private String ClientName;

    @Column(name = "ClientContact", unique = true, nullable = false)
    private String ClientContact;

    @Column(name = "EndTime", unique = true, nullable = false)
    private String EndTime;

    @Column(name = "PriceFinal", unique = true, nullable = false)
    private String PriceFinal;

    @Column(name = "Canceled", unique = true, nullable = false)
    private String Canceled;

}