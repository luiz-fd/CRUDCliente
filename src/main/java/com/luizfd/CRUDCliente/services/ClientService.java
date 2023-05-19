package com.luizfd.CRUDCliente.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luizfd.CRUDCliente.dto.ClientDTO;
import com.luizfd.CRUDCliente.entities.Client;
import com.luizfd.CRUDCliente.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> result = clientRepository.findById(id);
		Client client = result.get();
		ClientDTO dto = new ClientDTO(client);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable){
		Page<Client> result = clientRepository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
	}

	@Transactional()
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyDtoToEntity(dto,entity);
		entity = clientRepository.save(entity);
		return new ClientDTO(entity);
	}

	@Transactional()
	public ClientDTO update(Long id, ClientDTO dto) {
		Client entity = clientRepository.getReferenceById(id);
		copyDtoToEntity(dto,entity);
		entity = clientRepository.save(entity);
		return new ClientDTO(entity);
	}

	@Transactional()
	public void delete(Long id) {
		clientRepository.deleteById(id);	
	}

	private void copyDtoToEntity(ClientDTO dto, Client entity){
		entity.setName(dto.getName());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
	}
}
