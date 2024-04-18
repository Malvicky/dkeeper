package com.dkeeper.dkeeper.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "appointment")
@Data
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CodeId", unique = true, nullable = false)
    private String CodeId;

    @Column(name = "DateCreated", unique = true, nullable = false)
    private String DateCreated;

    @Column(name = "ClientID", unique = true, nullable = false)
    private String ClientID;

    @Column(name = "ClientName", unique = true, nullable = false)
    private String ClientName;

    @Column(name = "ClientContact", unique = true, nullable = false)
    private String ClientContact;

    @Column(name = "StartTime", unique = true, nullable = false)
    private String StartTime;

    @Column(name = "EndtimeExpected", unique = true, nullable = false)
    private String EndtimeExpected;

    @Column(name = "EndTime", unique = true, nullable = false)
    private String EndTime;

    @Column(name = "PriceExpected", unique = true, nullable = false)
    private String PriceExpected;

    @Column(name = "PriceFull", unique = true, nullable = false)
    private String PriceFull;

    @Column(name = "Discount", unique = true, nullable = false)
    private String Discount;

    @Column(name = "PriceFinal", unique = true, nullable = false)
    private String PriceFinal;

    @Column(name = "Canceled", unique = true, nullable = true)
    private String Canceled;

    @Column(name = "CancellationReason", unique = false, nullable = true)
    private String CancellationReason;
}

