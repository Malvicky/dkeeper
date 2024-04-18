package com.dkeeper.dkeeper.dto;
import lombok.Data;
import javax.persistence.Column;
@Data
public class ClientDto {
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
