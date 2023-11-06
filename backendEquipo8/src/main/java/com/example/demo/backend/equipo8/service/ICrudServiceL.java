package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.backend.equipo8.dto.LocalidadDTO;


public interface ICrudServiceL {
	
	public List<LocalidadDTO> findAll();

	public Optional<LocalidadDTO> findById(int id);

	public LocalidadDTO save(LocalidadDTO dto);

	public void delete(LocalidadDTO dto);
	

}