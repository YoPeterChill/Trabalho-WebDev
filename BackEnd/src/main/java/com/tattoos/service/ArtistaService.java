package com.tattoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tattoos.DTOs.ArtistaDTO;
import com.tattoos.models.Artista;
import com.tattoos.repository.ArtistaDAO;
import com.tattoos.services.exceptions.BusinessExceptions;

@Service
 public class ArtistaService {
	
	@Autowired
	private ArtistaDAO dao;

	@Transactional(readOnly = true)
	public Page<ArtistaDTO> findAll(Pageable pageable) {
		Page<Artista> result = dao.findAll(pageable);
		return result.map(obj -> new ArtistaDTO(obj));
				
		
	}


	@Transactional(readOnly = true)
	public ArtistaDTO findById(Integer id) {
		Artista result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros n達o encontrados!!!"));
		
		return new ArtistaDTO(result);
			
	}
  
	@Transactional(readOnly = true)
	public ArtistaDTO update(ArtistaDTO obj) {
		Artista entity = dao.findById(obj.getId())
				.orElseThrow(() -> new BusinessExceptions("Registros n達o encontrados!!!"));
		
		entity.setNome(obj.getNome());	
		entity.setPhotoURL(obj.getPhotoURL());
		return new ArtistaDTO(dao.save(entity));
		
	}	
	
	
	@Transactional(readOnly = true)
	public ArtistaDTO save(ArtistaDTO obj) {
		Artista entity = new Artista(obj);
		return new ArtistaDTO(dao.save(entity));
	}
	
	@Transactional(readOnly = true)
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}


}

