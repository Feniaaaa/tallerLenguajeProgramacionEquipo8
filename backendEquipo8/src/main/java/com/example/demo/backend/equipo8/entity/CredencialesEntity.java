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
@Table(name = "credenciales")
public class CredencialesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Column(name = "login")
	private String login;

	@NotBlank
	@Column(name = "contrasena")
	private String contrasena;
	


	public CredencialesEntity(@JsonProperty("id") int id, @JsonProperty("login") String login,
			@JsonProperty("apellido") String contrasena) {
		super();
		this.id = id;
		this.contrasena = contrasena;
		this.login = login;

	}

}
