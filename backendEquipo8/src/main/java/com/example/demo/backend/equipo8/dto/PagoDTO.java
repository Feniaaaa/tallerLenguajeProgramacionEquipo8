package com.example.demo.backend.equipo8.dto;

import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.PagoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
	private int id;

	
	private String metodoPago;

	

	public PagoEntity toEntity() {
		PagoEntity e = new PagoEntity();
		e.setId(this.getId());
		e.setMetodoPago(this.getMetodoPago());
		return e;
	}
}