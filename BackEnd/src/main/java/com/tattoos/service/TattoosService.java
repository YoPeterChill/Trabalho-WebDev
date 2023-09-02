package com.tattoos.service;


//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tattoos.DTOs.TattoosDTO;
import com.tattoos.models.ModelTattoos;
import com.tattoos.service.exceptions.BusinessExceptions;
import com.tattos.DAO.TattoosDAO;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
 public class TattoosService {
	@Autowired
	private TattoosDAO dao;
	
	
	
	
	@Transactional(readOnly = true)
	public Page<TattoosDTO> findAll(Pageable pageable) {
		Page<ModelTattoos> result = dao.findAll(pageable);
		return result.map(obj -> new TattoosDTO(obj));
				
		
	}


	@Transactional(readOnly = true)
	public TattoosDTO findById(Integer id) {
		ModelTattoos result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros n達o encontrados!!!"));
		
		return new TattoosDTO(result);
			
	}
  
	@Transactional
	public TattoosDTO update(TattoosDTO obj) {
		ModelTattoos entity = dao.findById(obj.getId())
				.orElseThrow(() -> new BusinessExceptions("Registros n達o encontrados!!!"));
		
		entity.setAltura(obj.getAltura());
		entity.setEspecificacoes(obj.getEspecificacoes());
		entity.setLargura(obj.getLargura());
		entity.setLocal(obj.getLocal());
		entity.setReferenciasURL(obj.getReferenciasURL());
		entity.setId(obj.getId());
		return new TattoosDTO(dao.save(entity));
		
	}	
	
	
	@Transactional
	public TattoosDTO save(TattoosDTO obj) {
		ModelTattoos entity = new ModelTattoos(obj.getId(),obj.getLocal(),obj.getEspecificacoes(),obj.getReferenciasURL(),obj.getAltura(),obj.getLargura(),obj.getStatus());
				
			
		
		
		return new TattoosDTO(dao.save(entity));
	}
	
	@Transactional
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}


}

