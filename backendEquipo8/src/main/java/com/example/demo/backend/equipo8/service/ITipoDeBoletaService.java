package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.backend.equipo8.dto.TipoDeBoletaDTO;

public interface ITipoDeBoletaService {
	
	public List<TipoDeBoletaDTO> findAll();
	
	public Optional<TipoDeBoletaDTO> findById(int id);
	
	public TipoDeBoletaDTO save(TipoDeBoletaDTO dto);
	
	public void delete(TipoDeBoletaDTO dto);

}

