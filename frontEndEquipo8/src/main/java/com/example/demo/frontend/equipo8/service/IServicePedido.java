package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.PedidoDTO;


public interface IServicePedido {

	public List<PedidoDTO> findAllREST();

	public PedidoDTO findByIdREST(int id);

	public PedidoDTO saveREST(PedidoDTO pedido);

	public PedidoDTO deleteREST(int id);
	
	
}