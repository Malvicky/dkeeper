package com.dkeeper.dkeeper.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "serviceProvide")
@Data
public class ServiceProvided implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CodeId", unique = true, nullable = false)
    private String CodeId;

    @Column(name = "ServiceId", unique = true, nullable = false)
    private String ServiceId;

    @Column(name = "PriceFinal", unique = true, nullable = false)
    private String PriceFinal;

}
