package com.example.demo.frontend.equipo8.service;

import java.util.List;

import com.example.demo.frontend.equipo8.dto.TipoDeBoletaDTO;

public interface ICrudServiceTipoDeBoleta {

	public List<TipoDeBoletaDTO> findAllREST() throws Exception;

	public TipoDeBoletaDTO findByIdREST(int id) throws Exception;

	public TipoDeBoletaDTO saveREST(TipoDeBoletaDTO tipoboleta) throws Exception;

	public TipoDeBoletaDTO deleteREST(int id) throws Exception;
	
}

