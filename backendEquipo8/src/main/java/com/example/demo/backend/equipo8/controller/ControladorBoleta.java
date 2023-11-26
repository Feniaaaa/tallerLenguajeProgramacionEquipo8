package com.example.demo.backend.equipo8.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.backend.equipo8.dto.BoletaDTO;
import com.example.demo.backend.equipo8.service.ICrudServiceBoleta;

@Controller
@RequestMapping("boleta")
public class ControladorBoleta {

	@Autowired
	private ICrudServiceBoleta servicio;

	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
	@ResponseBody
	@RequestMapping(value = "/REST", method = RequestMethod.POST)
	public ResponseEntity<BoletaDTO> agregarBoleta(@Valid @NonNull @RequestBody BoletaDTO dto) {
		return new ResponseEntity<>(servicio.save(dto), HttpStatus.OK);
	}

	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/REST", method = RequestMethod.GET)
    public ResponseEntity<List<BoletaDTO>> listAllBoletas() {
        List<BoletaDTO> boletas = servicio.findAll();
        return new ResponseEntity<>(boletas, HttpStatus.OK);
    }
	
	

	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	@ResponseBody
	@RequestMapping(value = "/REST/{id}", method = RequestMethod.GET)
	public ResponseEntity<BoletaDTO> getBoletaById(@PathVariable("id") int id) {
		Optional<BoletaDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			BoletaDTO dto = oDto.get();
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoletaDTO>(HttpStatus.NO_CONTENT);
		}
	}

	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseBody
	@RequestMapping(value = "/REST", method = RequestMethod.PUT)
	public ResponseEntity<BoletaDTO> updateBoleta(@Valid @NonNull @RequestBody BoletaDTO dto) {
		Optional<BoletaDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return new ResponseEntity<>(servicio.save(dto), HttpStatus.OK);
		} else
			return new ResponseEntity<BoletaDTO>(HttpStatus.NO_CONTENT);
	}

	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseBody
	@RequestMapping(value = "/REST/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BoletaDTO> deleteBoletaById(@PathVariable("id") int id) {
		Optional<BoletaDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			BoletaDTO dto = oDto.get();
			servicio.delete(oDto.get());
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoletaDTO>(HttpStatus.NO_CONTENT);
		}
	}
}
