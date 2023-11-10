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
import com.example.demo.frontend.equipo8.dto.LocalidadDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class CrudServiceLocalidadImpl implements ICrudServiceL {


	@Override
	public List<LocalidadDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<LocalidadDTO> localidades = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/localidad/REST"), LocalidadDTO[].class));
			return localidades;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LocalidadDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<LocalidadDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/localidad/REST" + "/" + id, LocalidadDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				LocalidadDTO dto = responseEntity.getBody();
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
	public LocalidadDTO saveREST(LocalidadDTO l) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<LocalidadDTO> requestEntity = new HttpEntity<>(l, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<LocalidadDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/localidad/REST",
					requestEntity, LocalidadDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				LocalidadDTO dto = responseEntity.getBody();
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
	public LocalidadDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<LocalidadDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/localidad/REST" + "/" + id, LocalidadDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				LocalidadDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/localidad/REST" + "/" + id);

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
