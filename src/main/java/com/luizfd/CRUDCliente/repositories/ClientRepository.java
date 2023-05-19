package com.luizfd.CRUDCliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luizfd.CRUDCliente.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
