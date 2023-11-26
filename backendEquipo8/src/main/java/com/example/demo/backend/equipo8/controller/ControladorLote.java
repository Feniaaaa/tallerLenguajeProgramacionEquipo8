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


import com.example.demo.backend.equipo8.dto.LoteDTO;
import com.example.demo.backend.equipo8.service.IServiceLote;

@Controller
@RequestMapping("lote")
public class ControladorLote {

	@Autowired
	private IServiceLote servicio;
	
	@ResponseBody
	@PostMapping("REST")
	public LoteDTO agregarLote(@Valid @NonNull @RequestBody LoteDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<LoteDTO> getAllLotes() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public LoteDTO getLoteById(@PathVariable("id") int id) {
		Optional<LoteDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			LoteDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	}

	@ResponseBody
	@PutMapping(("REST"))
	public LoteDTO updateLote(@Valid @NonNull @RequestBody LoteDTO dto) {
		Optional<LoteDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deleteLoteById(@PathVariable("id") int id) {
		Optional<LoteDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	

}
