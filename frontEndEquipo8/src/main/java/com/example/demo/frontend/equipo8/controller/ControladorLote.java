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

import com.example.demo.frontend.equipo8.dto.LoteDTO;
import com.example.demo.frontend.equipo8.service.IServiceLote;

@Controller
@RequestMapping("lote")
public class ControladorLote {

	@Autowired
	private IServiceLote servicio;

	// http://localhost:8081/lote/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) throws Exception {
		List<LoteDTO> lotes = servicio.findAllREST();
		model.addAttribute("lotes", lotes);
		return "rest/indexL";
	}

	// http://localhost:8081/lote/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("lote", new LoteDTO());
		return "rest/formL";
	}

	// http://localhost:8081/lote/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable int id, Model model) throws Exception {
		LoteDTO lote = servicio.findByIdREST(id);
		model.addAttribute("lote", lote);
		return "rest/formL";
	}

	// http://localhost:8081/lote/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid LoteDTO p, Model model) throws Exception {
		servicio.saveREST(p);
		return "redirect:/lote/listar/REST";
	}

	// http://localhost:8081/lote/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) throws Exception {
		servicio.deleteREST(id);
		return "redirect:/lote/listar/REST";
	}

}
