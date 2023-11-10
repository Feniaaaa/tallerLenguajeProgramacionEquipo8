package com.example.demo.frontend.equipo8.service;

import java.util.List;

import com.example.demo.frontend.equipo8.dto.TipoDeBoletaDTO;

public interface ICrudServiceTB {

	public List<TipoDeBoletaDTO> findAllREST();

	public TipoDeBoletaDTO findByIdREST(int id);

	public TipoDeBoletaDTO saveREST(TipoDeBoletaDTO tipoboleta);

	public TipoDeBoletaDTO deleteREST(int id);
	
}

