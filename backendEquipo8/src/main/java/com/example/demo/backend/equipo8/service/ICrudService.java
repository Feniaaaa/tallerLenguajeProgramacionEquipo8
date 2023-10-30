package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.backend.equipo8.dto.UsuarioDTO;


public interface ICrudService {
	
	public List<UsuarioDTO> findAll();

	public Optional<UsuarioDTO> findById(int id);

	public UsuarioDTO save(UsuarioDTO dto);

	public void delete(UsuarioDTO dto);
	

}
