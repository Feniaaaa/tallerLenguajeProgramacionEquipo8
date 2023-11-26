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


import com.example.demo.backend.equipo8.dto.PedidoDTO;
import com.example.demo.backend.equipo8.service.IServicePedido;

@Controller
@RequestMapping("pedido")
public class ControladorPedido {

	@Autowired
	private IServicePedido servicio;
	
	@ResponseBody
	@PostMapping("REST")
	public PedidoDTO agregarPedido(@Valid @NonNull @RequestBody PedidoDTO dto) {
		return servicio.save(dto);
	}
	
	
	@ResponseBody
	@GetMapping("REST")
	public List<PedidoDTO> getAllPedidos() {
		return servicio.findAll();
	}

	@ResponseBody
	@GetMapping("REST/{id}")
	public PedidoDTO getPedidoById(@PathVariable("id") int id) {
		Optional<PedidoDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			PedidoDTO dto = oDto.get();
			return dto;
		} else {
			return null;
		}
	}

	@ResponseBody
	@PutMapping(("REST"))
	public PedidoDTO updatePedido(@Valid @NonNull @RequestBody PedidoDTO dto) {
		Optional<PedidoDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return servicio.save(dto);
		} else
			return null;
	}

	@ResponseBody
	@DeleteMapping("REST/{id}")
	public boolean deletePedidooById(@PathVariable("id") int id) {
		Optional<PedidoDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			servicio.delete(oDto.get());
			return true;
		} else {
			return false;
		}
	}
	

}