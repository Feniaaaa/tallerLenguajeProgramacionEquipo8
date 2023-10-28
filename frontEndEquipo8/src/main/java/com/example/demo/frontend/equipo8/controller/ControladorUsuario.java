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

import com.example.demo.frontend.equipo8.dto.UsuarioDTO;
import com.example.demo.frontend.equipo8.service.ICrudService;

@Controller
@RequestMapping("usuario")
public class ControladorUsuario {

	@Autowired
	private ICrudService servicio;

	// http://localhost:8081/persona/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<UsuarioDTO> usuarios = servicio.findAllREST();
		model.addAttribute("usuarios", usuarios);
		return "rest/index";
	}

	// http://localhost:8081/persona/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("usuario", new UsuarioDTO());
		return "rest/form";
	}

	// http://localhost:8081/persona/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable int id, Model model) {
		UsuarioDTO usuario = servicio.findByIdREST(id);
		model.addAttribute("usuario", usuario);
		return "rest/form";
	}

	// http://localhost:8081/persona/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid UsuarioDTO p, Model model) {
		servicio.saveREST(p);
		return "redirect:/usuario/listar/REST";
	}

	// http://localhost:8081/persona/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/usuario/listar/REST";
	}

}
