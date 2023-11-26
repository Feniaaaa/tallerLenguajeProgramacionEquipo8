package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.LoteDTO;


public interface IServiceLote {

	public List<LoteDTO> findAllREST();

	public LoteDTO findByIdREST(int id);

	public LoteDTO saveREST(LoteDTO lote);

	public LoteDTO deleteREST(int id);
	
	
}

