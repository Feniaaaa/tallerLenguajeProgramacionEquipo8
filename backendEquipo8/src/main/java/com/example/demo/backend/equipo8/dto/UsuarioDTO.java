package com.example.demo.backend.equipo8.dto;


import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO{
	private int id;
	
	@NotBlank
	private String nombre;

	@NotBlank
	private String apellido;

	@NotBlank
	private String login;

	@NotBlank
	private String clave;
	
	
	public UsuarioEntity toEntity() {
		UsuarioEntity e = new UsuarioEntity();
		e.setId(this.getId());
		e.setNombre(this.getNombre());
		e.setApellido(this.getApellido());
		e.setLogin(this.getLogin());
		e.setClave(this.getClave());
		return e;
	}
}

