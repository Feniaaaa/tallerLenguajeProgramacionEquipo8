package com.example.demo.backend.equipo8.dto;

import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.ProveedorEntity;
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
	
	
	private LocalidadDTO localidad;
	
	
	
	public ProveedorEntity toEntity() {
		ProveedorEntity e = new ProveedorEntity();
		e.setId(this.getId());
		e.setNombre(this.getNombre());
		e.setApellido(this.getApellido());
		e.setNombre_compania(this.getNombre_compania());
		e.setTelefono(this.getTelefono());
		if (this.getLocalidad() != null) {
	        e.setLocalidad(this.getLocalidad().toEntity());
	        }
		return e;
	}
}