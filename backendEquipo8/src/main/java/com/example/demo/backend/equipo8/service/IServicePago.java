package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.backend.equipo8.dto.PagoDTO;


public interface IServicePago {
	
	public List<PagoDTO> findAll();

	public Optional<PagoDTO> findById(int id);

	public PagoDTO save(PagoDTO dto);

	public void delete(PagoDTO dto);
	

}