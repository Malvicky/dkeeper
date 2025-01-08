package com.dkeeper.dkeeper.controller;

import com.dkeeper.dkeeper.dto.ClientDto;
import com.dkeeper.dkeeper.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.activation.URLDataSource;
import javax.swing.*;
import java.net.URL;
import java.net.http.HttpClient;

@Controller
@RequestMapping("/client") //base URL
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientservice;

    @PostMapping("/add")
    public String addClient(@RequestBody ClientDto load){
        return clientservice.addClient(load);
        }

    @GetMapping("/get/{id}")
    public String getClient(@PathVariable Long id){
        return clientservice.getClient(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id)
    {clientservice.deleteClient(id);

    }


}
