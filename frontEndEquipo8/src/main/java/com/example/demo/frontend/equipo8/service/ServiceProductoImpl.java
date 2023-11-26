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


import com.example.demo.frontend.equipo8.dto.ProductoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class ServiceProductoImpl implements IServiceProducto {

	@Override
	public List<ProductoDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<ProductoDTO> productos = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/producto/REST"), ProductoDTO[].class));
			return productos;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProductoDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProductoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/producto/REST" + "/" + id, ProductoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProductoDTO dto = responseEntity.getBody();
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
	public ProductoDTO saveREST(ProductoDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<ProductoDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProductoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/producto/REST",
					requestEntity, ProductoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProductoDTO dto = responseEntity.getBody();
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
	public ProductoDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProductoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/producto/REST" + "/" + id, ProductoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProductoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/producto/REST" + "/" + id);

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
