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

import com.example.demo.frontend.equipo8.dto.BoletaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class CrudServiceBoletaImpl implements ICrudService {

	@Override
	public List<BoletaDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<BoletaDTO> boletas = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/boleta/REST"), BoletaDTO[].class));
			return boletas;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BoletaDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<BoletaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/boleta/REST" + "/" + id, BoletaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				BoletaDTO dto = responseEntity.getBody();
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
	public BoletaDTO saveREST(BoletaDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<BoletaDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<BoletaDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/boleta/REST",
					requestEntity, BoletaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				BoletaDTO dto = responseEntity.getBody();
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
	public BoletaDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<BoletaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/boleta/REST" + "/" + id, BoletaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				BoletaDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/boleta/REST" + "/" + id);

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