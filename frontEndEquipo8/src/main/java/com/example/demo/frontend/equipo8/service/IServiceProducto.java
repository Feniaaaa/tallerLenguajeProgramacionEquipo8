package com.example.demo.frontend.equipo8.service;

import java.util.List;
import com.example.demo.frontend.equipo8.dto.ProductoDTO;


public interface IServiceProducto {

	public List<ProductoDTO> findAllREST();

	public ProductoDTO findByIdREST(int id);

	public ProductoDTO saveREST(ProductoDTO producto);

	public ProductoDTO deleteREST(int id);
	
	
}
