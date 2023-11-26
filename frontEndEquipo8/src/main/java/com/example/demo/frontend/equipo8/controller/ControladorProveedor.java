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
import com.example.demo.frontend.equipo8.dto.ProveedorDTO;
import com.example.demo.frontend.equipo8.service.ICrudServiceLocalidad;
import com.example.demo.frontend.equipo8.service.ICrudServiceProveedor;





@Controller
@RequestMapping("proveedor")
public class ControladorProveedor {

	@Autowired
	private ICrudServiceProveedor servicio;
	
	@Autowired
	private ICrudServiceLocalidad servicioL;
	

	// http://localhost:8081/proveedor/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<ProveedorDTO> proveedores = servicio.findAllREST();
		model.addAttribute("proveedores", proveedores);
		List<LocalidadDTO> localidades = servicioL.findAllREST();
		model.addAttribute("localidades", localidades);
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
	public String saveREST(@Valid ProveedorDTO pr, Model model) {
		LocalidadDTO localidad = servicioL.findByIdREST(pr.getLocalidad().getId()); 
	    pr.setLocalidad(localidad);
		servicio.saveREST(pr);
		return "redirect:/proveedor/listar/REST";
	}

	// http://localhost:8081/proveedor/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/proveedor/listar/REST";
	}
	
	
}
