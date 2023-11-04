package com.example.demo.frontend.equipo8.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {
	private int id;

	@NotBlank
	private String nombre;

	@NotBlank
	private String apellido;
	
	@NotBlank
	private String nombre_compania;
	
	@NotBlank
	private String telefono;
	
	@NotBlank
	private String ciudad;
	
	
}
