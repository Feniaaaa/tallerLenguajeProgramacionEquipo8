package com.example.demo.frontend.equipo8.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.frontend.equipo8.dto.CarritoDTO;
import com.example.demo.frontend.equipo8.dto.ProductoDTO;

@Controller
@RequestMapping("carrito")
public class ControladorCarrito {

/*	//http://localhost:8081/carrito/guardar
	@PostMapping("/guardar")
	public String guardarCarrito(@RequestParam int id, @RequestParam ProductoDTO producto,Model model) {
	    CarritoDTO carrito = new CarritoDTO();
	    carrito.setId(id);
	    carrito.setProducto(producto);
		model.addAttribute("carritos", carrito);
	    return "usuario/pagar";
	} */
}
