package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.LocalidadDTO;


public interface ICrudServiceLocalidad {

	public List<LocalidadDTO> findAllREST() throws Exception;

	public LocalidadDTO findByIdREST(int id) throws Exception;
	
	public LocalidadDTO saveREST(LocalidadDTO localidad) throws Exception;

	public LocalidadDTO deleteREST(int id) throws Exception;
}