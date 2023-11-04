package com.example.demo.frontend.equipo8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cruds")
public class ControladorCruds {
	
	//http://localhost:8081/cruds/
	@GetMapping("/")
	public String Cruds(Model model) {	
		return "cruds/crud";
	}
}
