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


import com.example.demo.frontend.equipo8.dto.ProveedorDTO;
import com.example.demo.frontend.equipo8.service.ICrudServiceP;





@Controller
@RequestMapping("proveedor")
public class ControladorProveedor {

	@Autowired
	private ICrudServiceP servicio;
	

	// http://localhost:8081/proveedor/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<ProveedorDTO> proveedores = servicio.findAllREST();
		model.addAttribute("proveedores", proveedores);
		return "rest/indexP";
	}

	// http://localhost:8081/proveedor/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("proveedor", new ProveedorDTO());
		return "rest/formP";
	}

	// http://localhost:8081/proveedor/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable int id, Model model) {
		ProveedorDTO proveedor = servicio.findByIdREST(id);
		model.addAttribute("proveedor", proveedor);
		return "rest/formP";
	}

	// http://localhost:8081/proveedor/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid ProveedorDTO p, Model model) {
		servicio.saveREST(p);
		return "redirect:/proveedor/listar/REST";
	}

	// http://localhost:8081/proveedor/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/proveedor/listar/REST";
	}
	
	
}
