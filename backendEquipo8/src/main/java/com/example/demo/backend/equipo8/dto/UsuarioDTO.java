package com.example.demo.backend.equipo8.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.CredencialesEntity;
import com.example.demo.backend.equipo8.entity.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	private int id;

	@NotBlank
	private String nombre;

	@NotBlank
	private String apellido;
	
	@ManyToOne
    @JoinColumn(name = "id_login")
    CredencialesEntity CredencialesLogin;
	
	@ManyToOne
    @JoinColumn(name = "id_contrasena")
    CredencialesEntity CredencialesContrasena;

	public UsuarioEntity toEntity() {
		UsuarioEntity e = new UsuarioEntity();
		e.setId(this.getId());
		e.setApellido(this.getApellido());
		e.setNombre(this.getNombre());
		e.setCredencialesLogin(this.getCredencialesLogin());
		e.setCredencialesContrasena(this.getCredencialesContrasena());
		return e;
	}
}
