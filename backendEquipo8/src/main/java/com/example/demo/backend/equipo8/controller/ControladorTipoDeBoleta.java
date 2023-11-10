 package com.example.demo.backend.equipo8.controller;

import java.util.ArrayList;
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


import com.example.demo.backend.equipo8.dto.TipoDeBoletaDTO;
import com.example.demo.backend.equipo8.service.ITipoDeBoletaService;

@Controller
@RequestMapping("tipoboleta")
public class ControladorTipoDeBoleta {

	@Autowired
	private ITipoDeBoletaService servicio;
	
	@ResponseBody
	@PostMapping("REST")
	public TipoDeBoletaDTO agregarTipoDeBoleta(@Valid @NonNull @RequestBody TipoDeBoletaDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<TipoDeBoletaDTO> getAllTipoDeBoleta() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public TipoDeBoletaDTO getTipoDeBoletaById(@PathVariable("id") int id) {
		Optional<TipoDeBoletaDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			TipoDeBoletaDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	}

	@ResponseBody
	@PutMapping(("REST"))
	public TipoDeBoletaDTO updateTipoDeBoleta(@Valid @NonNull @RequestBody TipoDeBoletaDTO dto) {
		Optional<TipoDeBoletaDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deleteTipoDeBoletaById(@PathVariable("id") int id) {
		Optional<TipoDeBoletaDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	


}
