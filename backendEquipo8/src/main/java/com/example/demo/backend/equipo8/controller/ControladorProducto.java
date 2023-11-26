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


import com.example.demo.backend.equipo8.dto.ProductoDTO;
import com.example.demo.backend.equipo8.service.IServiceProducto;

@Controller
@RequestMapping("producto")
public class ControladorProducto {

	@Autowired
	private IServiceProducto servicio;
	
	@ResponseBody
	@PostMapping("REST")
	public ProductoDTO agregarProducto(@Valid @NonNull @RequestBody ProductoDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<ProductoDTO> getAllProductos() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public ProductoDTO getProductoById(@PathVariable("id") int id) {
		Optional<ProductoDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			ProductoDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	}

	@ResponseBody
	@PutMapping(("REST"))
	public ProductoDTO updateProducto(@Valid @NonNull @RequestBody ProductoDTO dto) {
		Optional<ProductoDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deleteProductoById(@PathVariable("id") int id) {
		Optional<ProductoDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	

}
