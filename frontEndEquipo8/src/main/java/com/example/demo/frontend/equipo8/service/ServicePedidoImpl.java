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

import com.example.demo.frontend.equipo8.dto.PedidoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class ServicePedidoImpl implements IServicePedido {

	@Override
	public List<PedidoDTO> findAllREST() {
		try {
			ObjectMapper unMapper = new ObjectMapper();

			List<PedidoDTO> lotes = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/pedido/REST"), PedidoDTO[].class));
			return lotes;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public PedidoDTO findByIdREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PedidoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/pedido/REST" + "/" + id, PedidoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PedidoDTO dto = responseEntity.getBody();
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
	public PedidoDTO saveREST(PedidoDTO p) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<PedidoDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PedidoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/pedido/REST",
					requestEntity, PedidoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PedidoDTO dto = responseEntity.getBody();
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
	public PedidoDTO deleteREST(int id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PedidoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/pedido/REST" + "/" + id, PedidoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PedidoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/pedido/REST" + "/" + id);

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
