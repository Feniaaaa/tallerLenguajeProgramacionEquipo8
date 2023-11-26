package com.example.demo.frontend.equipo8.dto;

import java.sql.Date;

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
    
}
