package com.example.demo.backend.equipo8.dto;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.BoletaEntity;
import com.example.demo.backend.equipo8.entity.LoteEntity;
import com.example.demo.backend.equipo8.entity.ProductoEntity;
import com.example.demo.backend.equipo8.entity.TipoDeBoletaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoteDTO{
	private int id;

    private String nombre;
    
    private String litros;
    
    private String fechaVencimiento;
	
    
	public LoteEntity toEntity() {
		LoteEntity e = new LoteEntity();
		e.setId(this.getId());
		e.setNombre(this.getNombre());
		e.setLitros(this.getLitros());
		e.setFechaVencimiento(this.getFechaVencimiento());
		return e;
	}
	
}
