package com.tattoos.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tattoos.DTOs.ClienteDTO;
import com.tattoos.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping ("/v1/slz/Cliente")
@Tag(name = "Endpoint de Cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;
    
	@GetMapping
	@Operation(summary = "Busca todas os Cliente")
	@Tag(name = "Endpoint de Cliente")
	public ResponseEntity<CollectionModel<ClienteDTO>> buscarTodos(
				@RequestParam(value="page", defaultValue = "0") int page,
				@RequestParam(value="limit", defaultValue = "12") int limit,
				@RequestParam(value="1direction", defaultValue = "asc") String direction) {
			Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
			Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));
			Page<ClienteDTO> pages = service.findAll(pageable);
			pages
				.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(ClienteController.class).findById(p.getId())).withSelfRel()
					)
				);
			return ResponseEntity.ok(CollectionModel.of(pages));
		}
	
	@GetMapping("/{id}")
	@Operation(summary = "Busca um cliente por id")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
			ClienteDTO objDTO = service.findById(id);
			objDTO.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	


	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Insere uma nova Cliente")
	public ResponseEntity<ClienteDTO> incluir(@RequestBody ClienteDTO objBody) {
		ClienteDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(ClienteController.class).findById(objDTO.getId())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}

	@PutMapping
	@Operation(summary = "Atualiza um Cliente")
	public ResponseEntity<ClienteDTO> atualizar(@RequestBody ClienteDTO objBody) {
		ClienteDTO objDTO = service.update(objBody);
		objDTO.add(linkTo(methodOn(ClienteController.class).findById(objDTO.getId())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui uma Cliente por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}