package com.dkeeper.dkeeper.repository;

import com.dkeeper.dkeeper.model.ServiceProvided;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, String> {
    // Additional query methods can be defined here if needed
}