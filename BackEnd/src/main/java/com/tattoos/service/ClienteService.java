package com.tattoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tattoos.DTOs.ClienteDTO;
import com.tattoos.models.Cliente;
import com.tattoos.repository.ClienteDAO;
import com.tattoos.services.exceptions.BusinessExceptions;

@Service
 public class ClienteService {
	
	@Autowired
	private ClienteDAO dao;

	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAll(Pageable pageable) {
		Page<Cliente> result = dao.findAll(pageable);
		return result.map(obj -> new ClienteDTO(obj));
				
		
	}


	@Transactional(readOnly = true)
	public ClienteDTO findById(Integer id) {
		Cliente result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros n達o encontrados!!!"));
		
		return new ClienteDTO(result);
			
	}
  
	@Transactional(readOnly = true)
	public ClienteDTO update(ClienteDTO obj) {
		Cliente entity = dao.findById(obj.getId())
				.orElseThrow(() -> new BusinessExceptions("Registros n達o encontrados!!!"));
		
		entity.setNome(obj.getNome());	
		entity.setCpf(obj.getCpf());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		entity.setData(obj.getData());
		entity.setSenha(obj.getSenha());
		entity.setData(obj.getData());
		return new ClienteDTO(dao.save(entity));
		
	}	
	
	
	@Transactional(readOnly = true)
	public ClienteDTO save(ClienteDTO obj) {
		Cliente entity = new Cliente(obj);
		return new ClienteDTO(dao.save(entity));
	}
	
	@Transactional(readOnly = true)
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}


}

