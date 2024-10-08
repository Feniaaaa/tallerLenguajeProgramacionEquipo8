package com.example.demo.backend.equipo8.entity;



import com.example.demo.backend.equipo8.dto.TipoDeBoletaDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Entity
@Table(name="tipoboleta")
public class TipoDeBoletaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;
    
    
    public TipoDeBoletaEntity(@JsonProperty("id") int id,@JsonProperty("nombre") String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }
    
	public TipoDeBoletaDTO toDTO() {
		TipoDeBoletaDTO dto = new TipoDeBoletaDTO();
		dto.setId(this.getId());
		dto.setNombre(this.getNombre());
		return dto;
	}
	
}
