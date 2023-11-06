package com.example.demo.frontend.equipo8.dto;

import javax.validation.constraints.NotBlank;


import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UsuarioDTO {
	private int id;
	
	@NotBlank
	private String nombre;

	@NotBlank
	private String apellido;

	@NotBlank
	private String login;

	@NotBlank
	private String clave;

}
