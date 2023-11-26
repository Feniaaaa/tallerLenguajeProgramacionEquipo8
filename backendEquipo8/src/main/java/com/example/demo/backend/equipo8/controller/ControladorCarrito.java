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



import com.example.demo.backend.equipo8.dto.CarritoDTO;
import com.example.demo.backend.equipo8.service.IServiceCarrito;

@Controller
@RequestMapping("carrito")
public class ControladorCarrito {

	@Autowired
	private IServiceCarrito servicio;
	
	
	@ResponseBody
	@PostMapping("REST")
	public CarritoDTO agregarCarrito(@Valid @NonNull @RequestBody CarritoDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<CarritoDTO> getAllCarritos() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public CarritoDTO getCarritoById(@PathVariable("id") int id) {
		Optional<CarritoDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			CarritoDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	} 

	@ResponseBody
	@PutMapping(("REST"))
	public CarritoDTO updateCarrito(@Valid @NonNull @RequestBody CarritoDTO dto) {
		Optional<CarritoDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deleteCarritoById(@PathVariable("id") int id) {
		Optional<CarritoDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	
}
