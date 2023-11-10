package com.example.demo.backend.equipo8.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.TipoDeBoletaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDeBoletaDTO {
	private int id;

    
    @Column(name = "nombre")
    private String nombre;
    

	public TipoDeBoletaEntity toEntity() {
		TipoDeBoletaEntity e = new TipoDeBoletaEntity();
		e.setId(this.getId());
		e.setNombre(this.getNombre());
		return e;
	}
	
}
