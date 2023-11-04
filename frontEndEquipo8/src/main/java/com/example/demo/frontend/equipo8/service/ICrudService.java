package com.example.demo.frontend.equipo8.service;

import java.util.List;

import com.example.demo.frontend.equipo8.dto.ProveedorDTO;

public interface ICrudService {

	public List<ProveedorDTO> findAllREST();

	public ProveedorDTO findByIdREST(int id);

	public ProveedorDTO saveREST(ProveedorDTO proveedor);

	public ProveedorDTO deleteREST(int id);
	
}
