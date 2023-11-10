package com.example.demo.frontend.equipo8.service;

import java.util.List;

import com.example.demo.frontend.equipo8.dto.LocalidadDTO;

public interface ICrudServiceL {

	public List<LocalidadDTO> findAllREST();

	public LocalidadDTO findByIdREST(int id);

	public LocalidadDTO saveREST(LocalidadDTO localidad);

	public LocalidadDTO deleteREST(int id);
	
}
