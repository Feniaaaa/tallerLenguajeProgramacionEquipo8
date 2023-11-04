package com.example.demo.frontend.equipo8.service;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.frontend.equipo8.dto.ProveedorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class CrudServiceProveedorImpl implements ICrudService {

	@Override
	public List<ProveedorDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<ProveedorDTO> proveedores = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/proveedor/REST"), ProveedorDTO[].class));
			return proveedores;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProveedorDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProveedorDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/proveedor/REST" + "/" + id, ProveedorDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProveedorDTO dto = responseEntity.getBody();
				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProveedorDTO saveREST(ProveedorDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<ProveedorDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProveedorDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/proveedor/REST",
					requestEntity, ProveedorDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProveedorDTO dto = responseEntity.getBody();
				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProveedorDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProveedorDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/proveedor/REST" + "/" + id, ProveedorDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProveedorDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/proveedor/REST" + "/" + id);

				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}