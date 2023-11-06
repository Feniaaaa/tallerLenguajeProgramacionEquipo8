package com.example.demo.frontend.equipo8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.frontend.equipo8.dto.UsuarioDTO;

@Controller
@RequestMapping("usuario")
public class ControladorUsuario {
	
	//http://localhost:8081/usuario/login
	@GetMapping("/login")
	public String login(Model model) {	
		UsuarioDTO usuario= new UsuarioDTO();
		model.addAttribute("usuario", usuario);
		return "usuario/login";
	}
	
	//http://localhost:8081/usuario/login/homepage
	@PostMapping("login/homepage")
	public String procesarInicioSesion(@RequestParam("login") String login, @RequestParam("clave") String clave, Model model) {
	    if (login.equals("Empleado1") && clave.equals("1234"))  {
	        return "usuario/home";
	    }
	    else {
	        return "usuario/error";
	    }

	}
	
	//http://localhost:8081/usuario/login/homepage/registroVenta
	@GetMapping("login/homepage/registroVenta")
	public String registroVenta(Model model) {	
		return "usuario/registroventa";
	}
	
	//http://localhost:8081/usuario/login/homepage/registroInventario
	@GetMapping("login/homepage/registroInventario")
	public String registroInventario(Model model) {	
		return "usuario/registroinventario";
	}
	
	//http://localhost:8081/usuario/login/homepage
	@GetMapping("login/homepage")
	public String volerHomepage(Model model) {	
		return "usuario/home";
	}
	
	//http://localhost:8081/usuario/login/homepage/registroVenta/pagar
	@GetMapping("login/homepage/registroVenta/pagar")
	public String pagar(Model model) {	
		return "usuario/pagar";
	}
}
