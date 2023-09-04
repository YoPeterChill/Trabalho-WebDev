package com.tattoos.DTOs;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.tattoos.models.ModelTattoos;
import com.tattoos.models.ModelTattoos.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class TattoosDTO extends RepresentationModel <TattoosDTO> implements Serializable {
	private static final long serialVersionUID = 1L;
	@EqualsAndHashCode.Include
		private int id;
		private String local ;
		private String especificacoes ;
		private String referenciasURL ;
		private Float largura ;
		private Status status;
		private Float altura;
		public TattoosDTO(ModelTattoos obj) {
			id = obj.getId();
			local = obj.getLocal();
			especificacoes = obj.getEspecificacoes();
			referenciasURL = obj.getReferenciasURL();
			largura = obj.getLargura();
			altura = obj.getAltura();
			status = obj.getStatus();
		}
}
