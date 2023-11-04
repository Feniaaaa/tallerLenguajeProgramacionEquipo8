package com.example.demo.backend.equipo8.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.dto.ProveedorDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "proveedor")
public class ProveedorEntity {
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
	@Column(name = "nombre_compania")
	private String nombre_compania;
	
	@NotBlank
	@Column(name = "telefono")
	private String telefono;
	
	@OneToOne
	@JoinColumn(name = "proveedor_localidad")
	LocalidadEntity localidad;


	public ProveedorEntity(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre,
			@JsonProperty("apellido") String apellido, @JsonProperty("nombre_compania") String nombre_compania, 
			@JsonProperty("telefono") String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombre_compania = nombre_compania;
		this.telefono = telefono;

	}

	public ProveedorDTO toDTO() {
		ProveedorDTO dto = new ProveedorDTO();
		dto.setId(this.getId());
		dto.setApellido(this.getApellido());
		dto.setNombre(this.getNombre());
		dto.setNombre_compania(this.getNombre_compania());
		dto.setTelefono(this.getTelefono());
		return dto;
	}

}
