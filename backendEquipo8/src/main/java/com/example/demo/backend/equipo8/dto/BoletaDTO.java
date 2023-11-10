package com.example.demo.backend.equipo8.dto;



import java.util.ArrayList;
import java.util.List;

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
	
	
	private TipoDeBoletaDTO tipoboleta;
	
	
	public BoletaEntity toEntity() {
		BoletaEntity e = new BoletaEntity();
		e.setId(this.getId());
		e.setMonto(this.getMonto());
		e.setFecha(this.getFecha());
		if (this.getTipoboleta() != null) {
		e.setTipoboleta(this.getTipoboleta().toEntity());
		}
		return e;
	}
	
}
