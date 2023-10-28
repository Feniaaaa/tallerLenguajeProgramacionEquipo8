package com.example.demo.frontend.equipo8.service;

import java.util.List;

import com.example.demo.frontend.equipo8.dto.UsuarioDTO;

public interface ICrudService {

	public List<UsuarioDTO> findAllREST();

	public UsuarioDTO findByIdREST(int id);

	public UsuarioDTO saveREST(UsuarioDTO persona);

	public UsuarioDTO deleteREST(int id);
}
