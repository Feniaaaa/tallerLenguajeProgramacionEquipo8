package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.LoteDTO;


public interface IServiceLote {

	public List<LoteDTO> findAllREST() throws Exception;

	public LoteDTO findByIdREST(int id) throws Exception;

	public LoteDTO saveREST(LoteDTO lote) throws Exception;

	public LoteDTO deleteREST(int id) throws Exception;
	
	
}

