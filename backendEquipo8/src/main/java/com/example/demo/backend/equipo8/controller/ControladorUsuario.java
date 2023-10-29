package com.example.demo.backend.equipo8.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.demo.backend.equipo8.dto.UsuarioDTO;
import com.example.demo.backend.equipo8.service.ICrudService;

@Controller
@RequestMapping("usuario")
public class ControladorUsuario {

	@Autowired
	private ICrudService servicio;
	
	@ResponseBody
	@PostMapping("REST")
	public UsuarioDTO agregarUsuario(@Valid @NonNull @RequestBody UsuarioDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<UsuarioDTO> getAllUsuarios() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public UsuarioDTO getUsuarioById(@PathVariable("id") int id) {
		Optional<UsuarioDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			UsuarioDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	}

	@ResponseBody
	@PutMapping(("REST"))
	public UsuarioDTO updateUsuario(@Valid @NonNull @RequestBody UsuarioDTO dto) {
		Optional<UsuarioDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deleteUsuarioById(@PathVariable("id") int id) {
		Optional<UsuarioDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	

}
