package com.dkeeper.dkeeper.service;

import com.dkeeper.dkeeper.dto.ClientDto;
import com.dkeeper.dkeeper.model.Client;
import jakarta.validation.Valid;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import java.io.Serializable;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.util.StringUtils;
import com.dkeeper.dkeeper.repository.ClientRepository;
import com.dkeeper.dkeeper.repository.EmployeeRepository;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
@Transactional
@Validated

public class ClientService {
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;


    public String addClient ( ClientDto load) {
        Optional<Client> clientOptionalAdd = clientRepository.findByEmail(load.getEmail());
        if (clientOptionalAdd.isPresent()) {
            return "email already exist";
        }
        if (!load.getEmail().contains("@")) {
            return "Invalid email format";
        } else {
            Client client = new Client();
            client.setFirstName(load.getFirst_name());
            client.setLastName(load.getLast_name());
            client.setUsername(load.getUsername());
            client.setPassword(load.getPassword());
            client.setEmail(load.getEmail());
            client.setPhone(load.getPhone());
            clientRepository.save(client);
            return "Account Created Successful";
        }
    }
        public String getClient (Long id) {
            Optional<Client> clientOptionalGet = clientRepository.findById(id);
            if (clientOptionalGet.isPresent()) {
                Client client = clientOptionalGet.get();
                return String.format("Client Found: %s %s, Email: %s",
                        client.getFirstName(), client.getLastName(), client.getEmail());
            } else {
                return "Client not found";
            }
        }
        public String deleteClient (Long id){
            Optional<Client> clientOptionalDelete = clientRepository.findById(id); // Changed variable name
            if (clientOptionalDelete.isPresent()) {
                clientRepository.deleteById(id);
                return "Client deleted successfully";
            } else {
                return "Client not found";
            }
        }

    }