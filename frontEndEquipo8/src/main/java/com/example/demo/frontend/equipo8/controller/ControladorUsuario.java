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
	//http://localhost:8081/usuario/login/homepage/informe
	@GetMapping("login/homepage/informe")
	public String informe(Model model) {	
		return "usuario/informe";
	}
	
	//http://localhost:8081/usuario/login/homepage/cerrar
	@GetMapping("login/homepage/cerrar")
	public String cerrar(Model model) {	
		return "usuario/cerrar";
	}
	
	//http://localhost:8081/usuario/login/homepage
		@GetMapping("login/homepage")
		public String volver(Model model) {	
			return "usuario/home";
		}
}
