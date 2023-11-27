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

import com.example.demo.frontend.equipo8.dto.LocalidadDTO;
import com.example.demo.frontend.equipo8.service.ICrudServiceLocalidad;


@Controller
@RequestMapping("localidad")
public class ControladorLocalidad {

	@Autowired
	private ICrudServiceLocalidad servicio;
	
	//http://localhost:8081/localidad/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) throws Exception {
	    List<LocalidadDTO> localidades = servicio.findAllREST();
        model.addAttribute("localidades", localidades);
	    return "rest/indexP";
	}

	// http://localhost:8081/localidad/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("localidad", new LocalidadDTO());
		return "rest/formP";
	}

	// http://localhost:8081/localidad/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable int id, Model model) throws Exception {
		LocalidadDTO localidad = servicio.findByIdREST(id);
		model.addAttribute("localidad", localidad);
		List<LocalidadDTO> localidades = servicio.findAllREST();
        model.addAttribute("localidades", localidades);
		return "rest/formP";
	}
	
	// http://localhost:8081/localidad/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid LocalidadDTO p, Model model) throws Exception {
    servicio.saveREST(p);
    return "redirect:/localidad/listar/REST";
}
	// http://localhost:8081/localidad/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) throws Exception {
		servicio.deleteREST(id);
		return "redirect:/localidad/listar/REST";
	}
	
	
	
}
