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


import com.example.demo.backend.equipo8.dto.PagoDTO;
import com.example.demo.backend.equipo8.service.IServicePago;

@Controller
@RequestMapping("pago")
public class ControladorPago {

	@Autowired
	private IServicePago servicio;
	
	@ResponseBody
	@PostMapping("REST")
	public PagoDTO agregarLocalidad(@Valid @NonNull @RequestBody PagoDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<PagoDTO> getAllPagos() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public PagoDTO getPagoById(@PathVariable("id") int id) {
		Optional<PagoDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			PagoDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	}

	@ResponseBody
	@PutMapping(("REST"))
	public PagoDTO updatePago(@Valid @NonNull @RequestBody PagoDTO dto) {
		Optional<PagoDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deletePagoById(@PathVariable("id") int id) {
		Optional<PagoDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	

}