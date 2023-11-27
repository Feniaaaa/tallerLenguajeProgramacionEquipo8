 package com.example.demo.backend.equipo8.controller;

import java.util.ArrayList;
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

import com.example.demo.backend.equipo8.dto.LocalidadDTO;
import com.example.demo.backend.equipo8.service.ICrudServiceLocalidad;

@Controller
@RequestMapping("localidad")
public class ControladorLocalidad {

	@Autowired
	private ICrudServiceLocalidad servicio;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
	@ResponseBody
	@RequestMapping(value = "/REST", method = RequestMethod.POST)
	public ResponseEntity<LocalidadDTO> agregarLocalidad(@Valid @NonNull @RequestBody LocalidadDTO dto) {
		return new ResponseEntity<>(servicio.save(dto), HttpStatus.OK);
	}

	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/REST", method = RequestMethod.GET)
    public ResponseEntity<List<LocalidadDTO>> listAllLocalidades() {
        List<LocalidadDTO> localidades = servicio.findAll();
        return new ResponseEntity<>(localidades, HttpStatus.OK);
    }
	
	

	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	@ResponseBody
	@RequestMapping(value = "/REST/{id}", method = RequestMethod.GET)
	public ResponseEntity<LocalidadDTO> getLocalidadById(@PathVariable("id") int id) {
		Optional<LocalidadDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			LocalidadDTO dto = oDto.get();
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<LocalidadDTO>(HttpStatus.NO_CONTENT);
		}
	}

	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseBody
	@RequestMapping(value = "/REST", method = RequestMethod.PUT)
	public ResponseEntity<LocalidadDTO> updateLocalidad(@Valid @NonNull @RequestBody LocalidadDTO dto) {
		Optional<LocalidadDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return new ResponseEntity<>(servicio.save(dto), HttpStatus.OK);
		} else
			return new ResponseEntity<LocalidadDTO>(HttpStatus.NO_CONTENT);
	}

	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseBody
	@RequestMapping(value = "/REST/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<LocalidadDTO> deleteLocalidadById(@PathVariable("id") int id) {
		Optional<LocalidadDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			LocalidadDTO dto = oDto.get();
			servicio.delete(oDto.get());
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<LocalidadDTO>(HttpStatus.NO_CONTENT);
		}
	}
}