package com.example.demo.backend.equipo8.dto;


import com.example.demo.backend.equipo8.entity.ProductoEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO{
	private int id;


	private int precio;


	private int cantidad;
	
	
	
	public ProductoEntity toEntity() {
		ProductoEntity e = new ProductoEntity();
		e.setId(this.getId());
		e.setPrecio(this.getPrecio());
		e.setCantidad(this.getCantidad());
		return e;
	}
	
}
