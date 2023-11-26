package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.CarritoDTO;


public interface IServiceCarrito {

	public List<CarritoDTO> findAllREST();

	public CarritoDTO findByIdREST(int id);

	public CarritoDTO saveREST(CarritoDTO carrito);

	public CarritoDTO deleteREST(int id);
	
	
}
