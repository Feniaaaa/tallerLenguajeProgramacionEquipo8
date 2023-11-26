package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.example.demo.backend.equipo8.dto.CarritoDTO;
import com.example.demo.backend.equipo8.entity.CarritoEntity;
import com.example.demo.backend.equipo8.entity.ProductoEntity;
import com.example.demo.backend.equipo8.repository.ICarritoRepository;




@Component
@Service
public class ServiceCarritoImpl implements IServiceCarrito {

	@Autowired
	private ICarritoRepository data;

	public List<CarritoDTO> findAll() {
		List<CarritoEntity> listE = (List<CarritoEntity>) data.findAll();
		List<CarritoDTO> listDto = new ArrayList<>();
		for (CarritoEntity e : listE) {
			CarritoDTO carritoDTO = e.toDTO();
            ProductoEntity productoEntity = e.getProducto();
            if (productoEntity != null) {
            	carritoDTO.setProducto(productoEntity.toDTO());
            }
            listDto.add(carritoDTO);
        }
        return listDto;
    }

	public Optional<CarritoDTO> findById(int id) {
		Optional<CarritoEntity> oe = data.findById(id);
		CarritoEntity e = oe.get();
		CarritoDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
	}

	public CarritoDTO save(CarritoDTO dto) {
		CarritoEntity e = data.save(dto.toEntity());
		return e.toDTO();
	}

	public void delete(CarritoDTO p) {
		data.delete(p.toEntity());
	}
	
    

}
