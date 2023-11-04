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


import com.example.demo.backend.equipo8.dto.ProveedorDTO;
import com.example.demo.backend.equipo8.service.ICrudService;

@Controller
@RequestMapping("proveedor")
public class ControladorProveedor {

	@Autowired
	private ICrudService servicio;
	
	@ResponseBody
	@PostMapping("REST")
	public ProveedorDTO agregarProveedor(@Valid @NonNull @RequestBody ProveedorDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<ProveedorDTO> getAllProveedores() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public ProveedorDTO getProveedorById(@PathVariable("id") int id) {
		Optional<ProveedorDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			ProveedorDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	}

	@ResponseBody
	@PutMapping(("REST"))
	public ProveedorDTO updateProveedor(@Valid @NonNull @RequestBody ProveedorDTO dto) {
		Optional<ProveedorDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deleteProveedoroById(@PathVariable("id") int id) {
		Optional<ProveedorDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	

}
