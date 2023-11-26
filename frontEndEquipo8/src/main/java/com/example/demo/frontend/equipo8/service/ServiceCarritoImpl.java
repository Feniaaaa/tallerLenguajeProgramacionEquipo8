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

import com.example.demo.frontend.equipo8.dto.CarritoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class ServiceCarritoImpl implements IServiceCarrito {

	@Override
	public List<CarritoDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<CarritoDTO> carritos = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/carrito/REST"), CarritoDTO[].class));
			return carritos;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CarritoDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CarritoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/carrito/REST" + "/" + id, CarritoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				CarritoDTO dto = responseEntity.getBody();
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
	public CarritoDTO saveREST(CarritoDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<CarritoDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CarritoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/carrito/REST",
					requestEntity, CarritoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				CarritoDTO dto = responseEntity.getBody();
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
	public CarritoDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CarritoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/carrito/REST" + "/" + id, CarritoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				CarritoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/carrito/REST" + "/" + id);

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
