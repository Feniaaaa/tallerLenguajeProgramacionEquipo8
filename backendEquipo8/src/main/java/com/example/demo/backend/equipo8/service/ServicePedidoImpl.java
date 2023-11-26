package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.PedidoDTO;
import com.example.demo.backend.equipo8.entity.PedidoEntity;
import com.example.demo.backend.equipo8.repository.IPedidoRepository;




@Component
@Service

public class ServicePedidoImpl implements IServicePedido {

	@Autowired
	private IPedidoRepository data;

	public List<PedidoDTO> findAll() {
		List<PedidoEntity> listL = (List<PedidoEntity>) data.findAll();
		List<PedidoDTO> listDto = new ArrayList<PedidoDTO>();
		for (PedidoEntity l : listL) {
			listDto.add(l.toDTO());
		}
		return listDto;
	}

	public Optional<PedidoDTO> findById(int id) {
		Optional<PedidoEntity> lo = data.findById(id);
		PedidoEntity l = lo.get();
		PedidoDTO dto = l.toDTO();
		return Optional.ofNullable(dto);
	}

	public PedidoDTO save(PedidoDTO dto) {
		PedidoEntity l = data.save(dto.toEntity());
		return l.toDTO();
	}

	public void delete(PedidoDTO i) {
		data.delete(i.toEntity());
	}
	
    

}