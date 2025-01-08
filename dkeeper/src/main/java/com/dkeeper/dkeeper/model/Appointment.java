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

    @Column(name = "unique_code", unique = true, nullable = false)
    private String uniqueCode;

    @Column(name = "date_created", unique = true, nullable = false)
    private String dateCreated;

    @Column(name = "start_time", unique = true, nullable = false)
    private String startTime;

    @Column(name = "endtime_expected", unique = true, nullable = false)
    private String endtimeExpected;

    @Column(name = "end_time", unique = true, nullable = false)
    private String endTime;

    @Column(name = "price_expected", unique = true, nullable = false)
    private String priceExpected;

    @Column(name = "price_full", unique = true, nullable = false)
    private String priceFull;

    @Column(name = "discount", unique = true, nullable = false)
    private String discount;

    @Column(name = "price_final", unique = true, nullable = false)
    private String priceFinal;

    @Column(name = "canceled", unique = true, nullable = true)
    private String canceled;

    @Column(name = "cancellation_reason", unique = false, nullable = true)
    private String cancellationReason;
}

