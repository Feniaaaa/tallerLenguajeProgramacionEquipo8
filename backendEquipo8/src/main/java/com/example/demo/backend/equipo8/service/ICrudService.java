package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.backend.equipo8.dto.ProveedorDTO;


public interface ICrudService {
	
	public List<ProveedorDTO> findAll();

	public Optional<ProveedorDTO> findById(int id);

	public ProveedorDTO save(ProveedorDTO dto);

	public void delete(ProveedorDTO dto);
	

}
