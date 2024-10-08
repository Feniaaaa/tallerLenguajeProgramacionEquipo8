package com.example.demo.backend.equipo8.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.example.demo.backend.equipo8.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Column(name = "nombre")
	private String nombre;

	@NotBlank
	@Column(name = "apellido")
	private String apellido;
	
	@NotBlank
	@Column(name = "login")
	private String login;
	
	@NotBlank
	@Column(name = "clave")
	private String clave;


	public UsuarioEntity(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre,
			@JsonProperty("apellido") String apellido,@JsonProperty("login") String login,@JsonProperty("clave") String clave) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.login = login;
		this.clave = clave;
	}
    
	public UsuarioDTO toDTO() {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(this.getId());
		dto.setNombre(this.getNombre());
		dto.setApellido(this.getApellido());
		dto.setLogin(this.getLogin());
		dto.setClave(this.getClave());
		return dto;
	}
}
