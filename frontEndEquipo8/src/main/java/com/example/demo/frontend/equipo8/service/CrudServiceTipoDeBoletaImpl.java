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

import com.example.demo.frontend.equipo8.dto.TipoDeBoletaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class CrudServiceTipoDeBoletaImpl implements ICrudServiceTB {


	@Override
	public List<TipoDeBoletaDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<TipoDeBoletaDTO> tipoboletasDTO = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/tipoboleta/REST"), TipoDeBoletaDTO[].class));
			return tipoboletasDTO;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TipoDeBoletaDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<TipoDeBoletaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/tipoboleta/REST" + "/" + id, TipoDeBoletaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				TipoDeBoletaDTO dto = responseEntity.getBody();
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
	public TipoDeBoletaDTO saveREST(TipoDeBoletaDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<TipoDeBoletaDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<TipoDeBoletaDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/tipoboleta/REST",
					requestEntity, TipoDeBoletaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				TipoDeBoletaDTO dto = responseEntity.getBody();
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
	public TipoDeBoletaDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<TipoDeBoletaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/tipoboleta/REST" + "/" + id, TipoDeBoletaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				TipoDeBoletaDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/tipoboleta/REST" + "/" + id);

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
