package com.example.demo.backend.equipo8.entity;

import com.example.demo.backend.equipo8.dto.LocalidadDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="localidad")
public class LocalidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "ciudad")
    private String ciudad;
    



    public LocalidadEntity(@JsonProperty("id") int id,@JsonProperty("ciudad") String ciudad) {
        super();
        this.id = id;
        this.ciudad = ciudad;
    }
    
	public LocalidadDTO toDTO() {
		LocalidadDTO dto = new LocalidadDTO();
		dto.setId(this.getId());
		dto.setCiudad(this.getCiudad());
		return dto;
	}
}
