package com.dkeeper.dkeeper.dto;
import lombok.Data;
import javax.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


    // Other fields and getters/setters


@Data
public class ClientDto {
    @Column(name = "first_name", unique = true, nullable = false)
    private String first_name;

    @Column(name = "last_name", unique = true, nullable = false)
    private String last_name;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "phone", unique = true, nullable = false,length = 9)
    private Integer phone;
}
