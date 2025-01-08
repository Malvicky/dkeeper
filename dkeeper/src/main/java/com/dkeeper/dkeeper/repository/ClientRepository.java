package com.dkeeper.dkeeper.repository;
import com.dkeeper.dkeeper.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByEmail(String email); //jpa Query
}

//native Query
//@Query(value = "select c from Client where c.ClientEmail",nativeQuery = true)
//Optional<Client> findClientEmail(@Param("ClientEmail")String ClientEmail);
