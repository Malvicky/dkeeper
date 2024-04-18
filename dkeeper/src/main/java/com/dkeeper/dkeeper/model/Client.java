package com.dkeeper.dkeeper.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ClientID", unique = true, nullable = false)
    private String ClientID;

    @Column(name = "Name", unique = true, nullable = false)
    private String Name;

    @Column(name = "ClientContact", unique = true, nullable = false)
    private String ClientContact;

    @Column(name = "ClientEmail", unique = true, nullable = false)
    private String ClientEmail;

    @Column(name = "ClientAddress", unique = true, nullable = false)
    private String ClientAddress;
}
