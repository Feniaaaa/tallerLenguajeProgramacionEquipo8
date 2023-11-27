package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.ProveedorDTO;


public interface ICrudServiceProveedor {

	public List<ProveedorDTO> findAllREST() throws Exception;

	public ProveedorDTO findByIdREST(int id) throws Exception;
	
	public ProveedorDTO saveREST(ProveedorDTO proveedor) throws Exception;

	public ProveedorDTO deleteREST(int id) throws Exception;
}
