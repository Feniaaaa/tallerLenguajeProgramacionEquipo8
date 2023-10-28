package com.example.demo.frontend.equipo8.dto;

import javax.validation.constraints.NotBlank;

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

}
