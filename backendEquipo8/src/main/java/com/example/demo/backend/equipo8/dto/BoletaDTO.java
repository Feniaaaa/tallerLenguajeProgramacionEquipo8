package com.example.demo.backend.equipo8.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.BoletaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaDTO {
	private int id;

	@NotBlank
	private int monto;

	@NotBlank
	private Date fecha;
	
	@NotBlank
	private String metodo_pago;
	

	public BoletaEntity toEntity() {
		BoletaEntity e = new BoletaEntity();
		e.setId(this.getId());
		e.setMonto(this.getMonto());
		e.setFecha(this.getFecha());
		e.setMetodo_pago(this.getMetodo_pago());
		return e;
	}
}
