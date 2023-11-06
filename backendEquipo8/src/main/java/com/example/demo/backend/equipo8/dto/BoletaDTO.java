package com.example.demo.backend.equipo8.dto;



import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.BoletaEntity;
import com.example.demo.backend.equipo8.entity.TipoDeBoletaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaDTO{
	private int id;

	@NotBlank
	private String monto;

	@NotBlank
	private String fecha;
	
	@JsonIgnore
	private TipoDeBoletaEntity tipoboleta;
	
	
	public BoletaEntity toEntity() {
		BoletaEntity e = new BoletaEntity();
		e.setId(this.getId());
		e.setMonto(this.getMonto());
		e.setFecha(this.getFecha());
		e.setTipoboleta(this.getTipoboleta());
		return e;
	}
}
