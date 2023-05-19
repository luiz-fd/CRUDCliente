package com.luizfd.CRUDCliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizfd.CRUDCliente.dto.ClientDTO;
import com.luizfd.CRUDCliente.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(value = "/{id}")
	public ClientDTO findById(@PathVariable Long id) {
		return clientService.findById(id);		
	}

	@GetMapping
	public Page<ClientDTO> findAll(Pageable pageable) {
		return clientService.findAll(pageable);		
	}

}
