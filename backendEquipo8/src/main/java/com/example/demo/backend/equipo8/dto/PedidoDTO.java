package com.example.demo.backend.equipo8.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.PedidoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
	private int id;

	
	private Date fecha_envio;

	private String estado;

	public PedidoEntity toEntity() {
		PedidoEntity e = new PedidoEntity();
		e.setId(this.getId());
		e.setFecha_envio(this.getFecha_envio());
		e.setEstado(this.getEstado());
		return e;
	}
}