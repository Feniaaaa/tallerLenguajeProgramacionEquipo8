package com.example.demo.frontend.equipo8.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.frontend.equipo8.dto.UsuarioDTO;
import com.example.demo.frontend.equipo8.service.ICrudService;


import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;




@Controller
@RequestMapping("usuario")
public class ControladorUsuario {

	@Autowired
	private ICrudService servicio;
	
	
	//http://localhost:8081/usuario/login
	@GetMapping("/login")
	public String login(Model model) {	
		UsuarioDTO usuario= new UsuarioDTO();
		model.addAttribute("usuario",usuario);
		return "login";
	}
	
	//http://localhost:8081/homepage
	@PostMapping("login/homepage")
	public String loginUsuario(@ModelAttribute("usuario") UsuarioDTO usuario) {
		return "home";
	}
	

	
	//http://localhost:8081/usuario/login/homepage
	//@PostMapping("/homepage") 
	//public String loginUsuario(@ModelAttribute("usuario") UsuarioEntity usuario) {
		//	String UsuarioId=usuario.getLogin();
			//java.util.Optional<UsuarioEntity> usuariodata= repo.findById(UsuarioId);
			//if(usuario.getContrasena().equals(usuariodata.get().getContrasena())) {
			//	return "home";
			//}else {
			//	return "home";
			//}
		//}
		
	// http://localhost:8081/usuario/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<UsuarioDTO> usuarios = servicio.findAllREST();
		model.addAttribute("usuarios", usuarios);
		return "rest/index";
	}

	// http://localhost:8081/usuario/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("usuario", new UsuarioDTO());
		return "rest/form";
	}

	// http://localhost:8081/usuario/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable int id, Model model) {
		UsuarioDTO usuario = servicio.findByIdREST(id);
		model.addAttribute("usuario", usuario);
		return "rest/form";
	}

	// http://localhost:8081/usuario/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid UsuarioDTO p, Model model) {
		servicio.saveREST(p);
		return "redirect:/usuario/listar/REST";
	}

	// http://localhost:8081/usuario/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable int id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/usuario/listar/REST";
	}
	
	
}
