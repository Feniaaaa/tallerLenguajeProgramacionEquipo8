package com.example.demo.backend.equipo8.dto;

import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.LocalidadEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadDTO {
	private int id;

	
	private String ciudad;

	

	public LocalidadEntity toEntity() {
		LocalidadEntity e = new LocalidadEntity();
		e.setId(this.getId());
		e.setCiudad(this.getCiudad());
		return e;
	}
}