package com.dkeeper.dkeeper.service;

import com.dkeeper.dkeeper.dto.ClientDto;
import com.dkeeper.dkeeper.model.Client;
import com.dkeeper.dkeeper.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
public String addClient(ClientDto load){
Client client =new Client();
client.setClientID(load.getClientID());
client.setName(load.getName());
client.setClientContact(load.getClientContact());
client.setClientAddress(load.getClientAddress());
client.setClientEmail(load.getClientEmail());
clientRepository.save(client);
return "Account Created Successful";
}}
