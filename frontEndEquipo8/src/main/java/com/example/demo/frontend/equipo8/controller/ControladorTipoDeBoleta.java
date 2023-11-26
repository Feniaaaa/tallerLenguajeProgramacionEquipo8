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

import com.example.demo.frontend.equipo8.dto.TipoDeBoletaDTO;
import com.example.demo.frontend.equipo8.service.ICrudServiceTipoDeBoleta;


@Controller
@RequestMapping("tipoboleta")
public class ControladorTipoDeBoleta {

	@Autowired
	private ICrudServiceTipoDeBoleta servicio;
	
	//http://localhost:8081/tipoboleta/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) throws Exception {
	    List<TipoDeBoletaDTO> tipoboletas = servicio.findAllREST();
        model.addAttribute("tipoboletas", tipoboletas);
	    return "rest/index";
	}

	// http://localhost:8081/tipoboleta/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("tipoboleta", new TipoDeBoletaDTO());
		return "rest/form";
	}

	// http://localhost:8081/tipoboleta/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable int id, Model model) throws Exception {
		TipoDeBoletaDTO tipoboleta = servicio.findByIdREST(id);
		model.addAttribute("tipoboleta", tipoboleta);
		List<TipoDeBoletaDTO> tipoboletas = servicio.findAllREST();
        model.addAttribute("tipoboletas", tipoboletas);
		return "rest/form";
	}
	
	// http://localhost:8081/tipoboleta/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid TipoDeBoletaDTO p, Model model) throws Exception {
    servicio.saveREST(p);
    return "redirect:/tipoboleta/listar/REST";
}
	// http://localhost:8081/tipoboleta/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) throws Exception {
		servicio.deleteREST(id);
		return "redirect:/tipoboleta/listar/REST";
	}
	
	
	
}
