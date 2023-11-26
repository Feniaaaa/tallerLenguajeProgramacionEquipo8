package com.example.demo.backend.equipo8.dto;


import com.example.demo.backend.equipo8.entity.CarritoEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO{
	private int id;

	private ProductoDTO producto;
	
	
	public CarritoEntity toEntity() {
		CarritoEntity e = new CarritoEntity();
		e.setId(this.getId());
		if (this.getProducto() != null) {
		e.setProducto(this.getProducto().toEntity());
		}
		return e;
	}
	
}
