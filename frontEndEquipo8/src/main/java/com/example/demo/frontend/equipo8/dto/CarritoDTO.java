package com.example.demo.frontend.equipo8.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO {
	
	private int id;	
	
	private ProductoDTO producto;
}
