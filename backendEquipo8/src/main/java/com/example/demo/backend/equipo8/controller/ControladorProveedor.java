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

import com.example.demo.backend.equipo8.dto.ProveedorDTO;
import com.example.demo.backend.equipo8.service.ICrudServiceProveedor;

@Controller
@RequestMapping("proveedor")
public class ControladorProveedor {

	@Autowired
	private ICrudServiceProveedor servicio;

	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
	@ResponseBody
	@RequestMapping(value = "/REST", method = RequestMethod.POST)
	public ResponseEntity<ProveedorDTO> agregarProveedor(@Valid @NonNull @RequestBody ProveedorDTO dto) {
		return new ResponseEntity<>(servicio.save(dto), HttpStatus.OK);
	}

	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/REST", method = RequestMethod.GET)
    public ResponseEntity<List<ProveedorDTO>> listAllProveedores() {
        List<ProveedorDTO> Proveedores = servicio.findAll();
        return new ResponseEntity<>(Proveedores, HttpStatus.OK);
    }
	
	

	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	@ResponseBody
	@RequestMapping(value = "/REST/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProveedorDTO> getProveedorById(@PathVariable("id") int id) {
		Optional<ProveedorDTO> oDto = servicio.findById(id);
		if (oDto.isPresent()) {
			ProveedorDTO dto = oDto.get();
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProveedorDTO>(HttpStatus.NO_CONTENT);
		}
	}

	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseBody
	@RequestMapping(value = "/REST", method = RequestMethod.PUT)
	public ResponseEntity<ProveedorDTO> updateBoleta(@Valid @NonNull @RequestBody ProveedorDTO dto) {
		Optional<ProveedorDTO> oDto = servicio.findById(dto.getId());
		if (oDto.isPresent() == true) {
			return new ResponseEntity<>(servicio.save(dto), HttpStatus.OK);
		} else
			return new ResponseEntity<ProveedorDTO>(HttpStatus.NO_CONTENT);
	}

	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseBody
	@RequestMapping(value = "/REST/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ProveedorDTO> deleteProveedorById(@PathVariable("id") int id) {
		Optional<ProveedorDTO> oDto = servicio.findById(id);
		if (oDto.isPresent() == true) {
			ProveedorDTO dto = oDto.get();
			servicio.delete(oDto.get());
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProveedorDTO>(HttpStatus.NO_CONTENT);
		}
	}
}
