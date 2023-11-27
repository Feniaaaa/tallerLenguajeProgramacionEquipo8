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
import com.example.demo.frontend.equipo8.dto.ProveedorDTO;
import com.example.demo.frontend.equipo8.dto.LocalidadDTO;
import com.example.demo.frontend.equipo8.service.ICrudServiceProveedor;
import com.example.demo.frontend.equipo8.service.ICrudServiceLocalidad;




@Controller
@RequestMapping("proveedor")
public class ControladorProveedor {

	@Autowired
	private ICrudServiceProveedor servicio;
	
	@Autowired
	private ICrudServiceLocalidad servicio2;

	//http://localhost:8081/boleta/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) throws Exception {
	    List<ProveedorDTO> proveedores = servicio.findAllREST();
	    List<LocalidadDTO> localidades = servicio2.findAllREST();
	    model.addAttribute("proveedores", proveedores);
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
	public String editarREST(@PathVariable int id, Model model) throws Exception {
		ProveedorDTO proveedor = servicio.findByIdREST(id);
		model.addAttribute("proveedor", proveedor);
		return "rest/formP";
	}

	// http://localhost:8081/proveedor/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid ProveedorDTO p, Model model) throws Exception {
	LocalidadDTO localidad = servicio2.findByIdREST(p.getLocalidad().getId()); 
	p.setLocalidad(localidad);
    servicio.saveREST(p);
    return "redirect:/proveedor/listar/REST";
}

	// http://localhost:8081/proveedor/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) throws Exception {
		servicio.deleteREST(id);
		return "redirect:/proveedor/listar/REST";
	}
			

	}





