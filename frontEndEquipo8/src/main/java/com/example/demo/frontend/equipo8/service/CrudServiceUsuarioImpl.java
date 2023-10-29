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

import com.example.demo.frontend.equipo8.dto.UsuarioDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class CrudServiceUsuarioImpl implements ICrudService {

	@Override
	public List<UsuarioDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<UsuarioDTO> usuarios = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/usuario/REST"), UsuarioDTO[].class));
			return usuarios;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UsuarioDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UsuarioDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/usuario/REST" + "/" + id, UsuarioDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				UsuarioDTO dto = responseEntity.getBody();
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
	public UsuarioDTO saveREST(UsuarioDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<UsuarioDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UsuarioDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/usuario/REST",
					requestEntity, UsuarioDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				UsuarioDTO dto = responseEntity.getBody();
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
	public UsuarioDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UsuarioDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/usuario/REST" + "/" + id, UsuarioDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				UsuarioDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/usuario/REST" + "/" + id);

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