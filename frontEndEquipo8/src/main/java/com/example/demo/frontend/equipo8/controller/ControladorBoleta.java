package com.example.demo.frontend.equipo8.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.frontend.equipo8.dto.BoletaDTO;
import com.example.demo.frontend.equipo8.dto.TipoDeBoletaDTO;
import com.example.demo.frontend.equipo8.service.ICrudServiceBoleta;
import com.example.demo.frontend.equipo8.service.ICrudServiceTipoDeBoleta;




@Controller
@RequestMapping("boleta")
public class ControladorBoleta {

	@Autowired
	private ICrudServiceBoleta servicio;
	
	@Autowired
	private ICrudServiceTipoDeBoleta servicio2;

	//http://localhost:8081/boleta/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) throws Exception {
	    List<BoletaDTO> boletas = servicio.findAllREST();
	    model.addAttribute("boletas", boletas);
	    List<TipoDeBoletaDTO> tipoboletas = servicio2.findAllREST();
        model.addAttribute("tipoboletas", tipoboletas);
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
	public String editarREST(@PathVariable int id, Model model) throws Exception {
		BoletaDTO boleta = servicio.findByIdREST(id);
		model.addAttribute("boleta", boleta);
		return "rest/form";
	}

	// http://localhost:8081/boleta/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid BoletaDTO p, Model model) throws Exception {
	TipoDeBoletaDTO tipoBoleta = servicio2.findByIdREST(p.getTipoboleta().getId()); 
	p.setTipoboleta(tipoBoleta);
    servicio.saveREST(p);
    return "redirect:/boleta/listar/REST";
}

	// http://localhost:8081/boleta/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) throws Exception {
		servicio.deleteREST(id);
		return "redirect:/boleta/listar/REST";
	}
			

	}




