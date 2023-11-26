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

import com.example.demo.frontend.equipo8.dto.PagoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class ServicePagoImpl implements IServicePago {

	@Override
	public List<PagoDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<PagoDTO> lotes = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/pago/REST"), PagoDTO[].class));
			return lotes;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public PagoDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PagoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/pago/REST" + "/" + id, PagoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PagoDTO dto = responseEntity.getBody();
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
	public PagoDTO saveREST(PagoDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<PagoDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PagoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/pago/REST",
					requestEntity, PagoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PagoDTO dto = responseEntity.getBody();
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
	public PagoDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PagoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/pago/REST" + "/" + id, PagoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PagoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/pago/REST" + "/" + id);

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