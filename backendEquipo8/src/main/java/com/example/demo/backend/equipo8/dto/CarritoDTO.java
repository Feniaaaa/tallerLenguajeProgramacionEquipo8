package com.example.demo.backend.equipo8.dto;


import java.util.List;

import com.example.demo.backend.equipo8.entity.CarritoEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO{
	private int id;

	private List<String> carritoCompra;
	
	
	public CarritoEntity toEntity() {
		CarritoEntity e = new CarritoEntity();
		e.setId(this.getId());
		e.setCarritoCompra(this.getCarritoCompra());
		return e;
	}
	
}
