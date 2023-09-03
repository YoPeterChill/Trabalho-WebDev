package com.tattoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import com.tattoos.DTOs.PessoaDTO;
import com.tattoos.models.Pessoa;
import com.tattoos.repository.PessoaDAO;
import com.tattoos.services.exceptions.BusinessExceptions;

@Service
public class PessoaService {

	@Autowired
	private PessoaDAO dao;
	

	@Transactional(readOnly = true)
	public Page<PessoaDTO> findAll(Pageable pageable) {
		Page<Pessoa> result = dao.findAll(pageable);
		return result.map(obj -> new PessoaDTO(obj));
				
	}


	@Transactional(readOnly = true)
	public PessoaDTO findById(Integer id) {
		Pessoa result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		return new PessoaDTO(result);
			
	}
    
	@Transactional
	public PessoaDTO update(PessoaDTO obj) {
		Pessoa entity = dao.findById(obj.getCodigo())
				.orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));

		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setData(obj.getData());
		entity.setEmail(obj.getEmail());
		entity.setCpf(obj.getCpf());
		entity.setEscolaridade(obj.getEscolaridade());
		entity.setProfissao(obj.getProfissao());
		entity.setTelefone(obj.getTelefone());
		return new PessoaDTO(dao.save(entity));
		
	}	
    
    @Transactional
    public PessoaDTO save(@RequestBody PessoaDTO obj) {
    	Pessoa modelObj = new Pessoa(obj.getCodigo(), obj.getNome(), obj.getCpf(),obj.getData(), obj.getEmail(), obj.getEscolaridade(), obj.getProfissao(), obj.getTelefone());
		boolean cpfExists = dao.findByCpf(modelObj.getCpf())
				.stream()
				.anyMatch(objResult -> !objResult.equals(modelObj));
		
		if (cpfExists) {
			throw new BusinessExceptions("Cpf já existente!");
		}
    	return new PessoaDTO(dao.save(modelObj));
    }
	@Transactional
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
