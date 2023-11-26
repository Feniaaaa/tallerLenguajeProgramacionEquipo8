package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.backend.equipo8.dto.BoletaDTO;


public interface ICrudServiceBoleta {

	public List<BoletaDTO> findAll();

	public Optional<BoletaDTO> findById(int id);

	public BoletaDTO save(BoletaDTO dto);

	public void delete(BoletaDTO dto);
	
}
