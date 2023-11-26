package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.PagoDTO;


public interface IServicePago {

	public List<PagoDTO> findAllREST();

	public PagoDTO findByIdREST(int id);

	public PagoDTO saveREST(PagoDTO pago);

	public PagoDTO deleteREST(int id);
	
	
}
