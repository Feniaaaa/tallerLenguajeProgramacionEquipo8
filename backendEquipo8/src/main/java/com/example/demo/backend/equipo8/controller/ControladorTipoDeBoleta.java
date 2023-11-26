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

import com.example.demo.backend.equipo8.dto.BoletaDTO;
import com.example.demo.backend.equipo8.dto.TipoDeBoletaDTO;
import com.example.demo.backend.equipo8.service.ICrudServiceTipoDeBoleta;

@Controller
@RequestMapping("tipoboleta")
public class ControladorTipoDeBoleta {

	@Autowired
	private ICrudServiceTipoDeBoleta servicio;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
	@ResponseBody
	@RequestMapping(value = "/REST", method = RequestMethod.POST)
	public ResponseEntity<TipoDeBoletaDTO> agregarTipoBoleta(@Valid @NonNull @RequestBody TipoDeBoletaDTO dto) {
		return new ResponseEntity<>(servicio.save(dto), HttpStatus.OK);
	}

	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/REST", method = RequestMethod.GET)
    public ResponseEntity<List<TipoDeBoletaDTO>> listAllTipoBoletas() {
        List<TipoDeBoletaDTO> tipoboletas = servicio.findAll();
        return new ResponseEntity<>(tipoboletas, HttpStatus.OK);
    }
	
	

	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	@ResponseBody
	@RequestMapping(value = "/REST/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipoDeBoletaDTO> getTipoBoletaById(@PathVariable("id") int id) {
		Optional<TipoDeBoletaDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			TipoDeBoletaDTO dto = oDto.get();
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<TipoDeBoletaDTO>(HttpStatus.NO_CONTENT);
		}
	}

	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseBody
	@RequestMapping(value = "/REST", method = RequestMethod.PUT)
	public ResponseEntity<TipoDeBoletaDTO> updateTipoBoleta(@Valid @NonNull @RequestBody TipoDeBoletaDTO dto) {
		Optional<TipoDeBoletaDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return new ResponseEntity<>(servicio.save(dto), HttpStatus.OK);
		} else
			return new ResponseEntity<TipoDeBoletaDTO>(HttpStatus.NO_CONTENT);
	}

	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseBody
	@RequestMapping(value = "/REST/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TipoDeBoletaDTO> deleteTipoBoletaById(@PathVariable("id") int id) {
		Optional<TipoDeBoletaDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			TipoDeBoletaDTO dto = oDto.get();
			servicio.delete(oDto.get());
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<TipoDeBoletaDTO>(HttpStatus.NO_CONTENT);
		}
	}
}

