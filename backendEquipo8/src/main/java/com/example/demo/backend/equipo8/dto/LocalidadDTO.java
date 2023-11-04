package com.example.demo.backend.equipo8.dto;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@NotBlank
	private String ciudad;

	

	public LocalidadEntity toEntity() {
		LocalidadEntity e = new LocalidadEntity();
		e.setId(this.getId());
		e.setCiudad(this.getCiudad());
		return e;
	}
}