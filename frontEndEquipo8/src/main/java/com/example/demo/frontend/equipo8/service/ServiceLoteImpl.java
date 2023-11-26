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

import com.example.demo.frontend.equipo8.dto.LoteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class ServiceLoteImpl implements IServiceLote {

	@Override
	public List<LoteDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<LoteDTO> lotes = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/lote/REST"), LoteDTO[].class));
			return lotes;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LoteDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<LoteDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/lote/REST" + "/" + id, LoteDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				LoteDTO dto = responseEntity.getBody();
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
	public LoteDTO saveREST(LoteDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<LoteDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<LoteDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/lote/REST",
					requestEntity, LoteDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				LoteDTO dto = responseEntity.getBody();
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
	public LoteDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<LoteDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/lote/REST" + "/" + id, LoteDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				LoteDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/lote/REST" + "/" + id);

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
