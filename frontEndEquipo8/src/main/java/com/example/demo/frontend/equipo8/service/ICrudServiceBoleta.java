package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.BoletaDTO;


public interface ICrudServiceBoleta {

	public List<BoletaDTO> findAllREST();

	public BoletaDTO findByIdREST(int id);

	public BoletaDTO saveREST(BoletaDTO boleta);

	public BoletaDTO deleteREST(int id);
	
	
}
