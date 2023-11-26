package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.ProductoDTO;
import com.example.demo.backend.equipo8.entity.ProductoEntity;
import com.example.demo.backend.equipo8.repository.IProductoRepository;



@Component
@Service
public class ServiceProductoImpl implements IServiceProducto {

	@Autowired
	private IProductoRepository data;
	

	public List<ProductoDTO> findAll() {
		List<ProductoEntity> listE = (List<ProductoEntity>) data.findAll();
		List<ProductoDTO> listDto = new ArrayList<ProductoDTO>();
		for (ProductoEntity e : listE) {
			listDto.add(e.toDTO());
		}
		return listDto;
	}
	
	public Optional<ProductoDTO> findById(int id) {
		Optional<ProductoEntity> oe = data.findById(id);
		ProductoEntity e = oe.get();
		ProductoDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
	}
	

	public ProductoDTO save(ProductoDTO dto) {
		ProductoEntity e = data.save(dto.toEntity());
		
		return e.toDTO();
	}
	
	public void delete(ProductoDTO p) {
		data.delete(p.toEntity());
	}

}
