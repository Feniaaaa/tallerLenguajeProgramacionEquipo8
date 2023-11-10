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


import com.example.demo.backend.equipo8.dto.BoletaDTO;
import com.example.demo.backend.equipo8.service.ICrudService;
import com.example.demo.backend.equipo8.service.ITipoDeBoletaService;

@Controller
@RequestMapping("boleta")
public class ControladorBoleta {

	@Autowired
	private ICrudService servicio;
	
	
	@ResponseBody
	@PostMapping("REST")
	public BoletaDTO agregarBoleta(@Valid @NonNull @RequestBody BoletaDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<BoletaDTO> getAllBoletas() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public BoletaDTO getBoletaById(@PathVariable("id") int id) {
		Optional<BoletaDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			BoletaDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	} 

	@ResponseBody
	@PutMapping(("REST"))
	public BoletaDTO updateBoleta(@Valid @NonNull @RequestBody BoletaDTO dto) {
		Optional<BoletaDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deleteBoletaById(@PathVariable("id") int id) {
		Optional<BoletaDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	
}
