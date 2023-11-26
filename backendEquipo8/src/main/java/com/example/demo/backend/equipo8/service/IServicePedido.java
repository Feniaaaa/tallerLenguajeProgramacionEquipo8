package com.example.demo.backend.equipo8.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.backend.equipo8.dto.PedidoDTO;


public interface IServicePedido {
	
	public List<PedidoDTO> findAll();

	public Optional<PedidoDTO> findById(int id);

	public PedidoDTO save(PedidoDTO dto);

	public void delete(PedidoDTO dto);
	

}