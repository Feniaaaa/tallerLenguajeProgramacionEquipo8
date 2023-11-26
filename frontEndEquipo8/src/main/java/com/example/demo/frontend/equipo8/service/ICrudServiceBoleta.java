package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.BoletaDTO;


public interface ICrudServiceBoleta {

	public List<BoletaDTO> findAllREST() throws Exception;

	public BoletaDTO findByIdREST(int id) throws Exception;
	
	public BoletaDTO saveREST(BoletaDTO boleta) throws Exception;

	public BoletaDTO deleteREST(int id) throws Exception;
}
