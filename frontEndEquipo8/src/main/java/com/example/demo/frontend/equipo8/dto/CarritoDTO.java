package com.example.demo.frontend.equipo8.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO {
	
	private int id;	
	
	private List<String> carritoCompra;
}
