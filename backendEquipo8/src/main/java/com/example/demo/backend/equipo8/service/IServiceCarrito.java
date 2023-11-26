package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.backend.equipo8.dto.CarritoDTO;


public interface IServiceCarrito {

	public List<CarritoDTO> findAll();

	public Optional<CarritoDTO> findById(int id);

	public CarritoDTO save(CarritoDTO dto);

	public void delete(CarritoDTO dto);
	
}
