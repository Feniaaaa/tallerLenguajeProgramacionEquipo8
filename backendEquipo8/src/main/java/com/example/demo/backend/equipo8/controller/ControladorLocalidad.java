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


import com.example.demo.backend.equipo8.dto.LocalidadDTO;
import com.example.demo.backend.equipo8.service.ICrudServiceL;

@Controller
@RequestMapping("localidad")
public class ControladorLocalidad {

	@Autowired
	private ICrudServiceL servicio;
	
	@ResponseBody
	@PostMapping("REST")
	public LocalidadDTO agregarLocalidad(@Valid @NonNull @RequestBody LocalidadDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<LocalidadDTO> getAllLocalidades() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public LocalidadDTO getLocalidadById(@PathVariable("id") int id) {
		Optional<LocalidadDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			LocalidadDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	}

	@ResponseBody
	@PutMapping(("REST"))
	public LocalidadDTO updateLocalidad(@Valid @NonNull @RequestBody LocalidadDTO dto) {
		Optional<LocalidadDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deleteLocalidadoById(@PathVariable("id") int id) {
		Optional<LocalidadDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	

}