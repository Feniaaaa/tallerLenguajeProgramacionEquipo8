package com.example.demo.frontend.equipo8.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.frontend.equipo8.dto.BoletaDTO;
import com.example.demo.frontend.equipo8.service.ICrudService;




@Controller
@RequestMapping("boleta")
public class ControladorBoleta {

	@Autowired
	private ICrudService servicio;
	
	// http://localhost:8081/boleta/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<BoletaDTO> boletas = servicio.findAllREST();
		model.addAttribute("boletas", boletas);
		return "rest/index";
	}

	// http://localhost:8081/boleta/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("boleta", new BoletaDTO());
		return "rest/form";
	}

	// http://localhost:8081/boleta/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable int id, Model model) {
		BoletaDTO boleta = servicio.findByIdREST(id);
		model.addAttribute("boleta", boleta);
		return "rest/form";
	}

	// http://localhost:8081/boleta/grabar/REST
	/*
	  @PostMapping("grabar/REST")
	public String saveREST(@Valid BoletaDTO p, Model model) {
		servicio.saveREST(p);
		
		return "redirect:/boleta/listar/REST";
	}
	*/ 
	@PostMapping("grabar/REST")
	public String saveREST(@Valid BoletaDTO p, @RequestParam("tipoboleta_id") String tipoboleta_id, Model model) {
	if (tipoboleta_id == "1") {
		p.setTipoboleta_id("Factura");
	} else if (tipoboleta_id == "2") {
		p.setTipoboleta_id("Boleta");
	}
    servicio.saveREST(p);
    return "redirect:/boleta/listar/REST";
}
	/*
	// http://localhost:8081/boleta/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid BoletaDTO p, Model model) {
	    servicio.saveREST(p);
	    model.addAttribute("tipoboleta");
	    return "redirect:/boleta/listar/REST";
	}
	*/ 
	// http://localhost:8081/boleta/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/boleta/listar/REST";
	}
	
	
	
}
