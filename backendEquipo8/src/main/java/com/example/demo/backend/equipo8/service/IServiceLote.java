package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.backend.equipo8.dto.LoteDTO;


public interface IServiceLote {

	public List<LoteDTO> findAll();

	public Optional<LoteDTO> findById(int id);

	public LoteDTO save(LoteDTO dto);

	public void delete(LoteDTO dto);
	
}