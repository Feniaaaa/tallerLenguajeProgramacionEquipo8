package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.PagoDTO;
import com.example.demo.backend.equipo8.entity.PagoEntity;
import com.example.demo.backend.equipo8.repository.IPagoRepository;




@Component
@Service

public class ServicePagoImpl implements IServicePago {

	@Autowired
	private IPagoRepository data;

	public List<PagoDTO> findAll() {
		List<PagoEntity> listL = (List<PagoEntity>) data.findAll();
		List<PagoDTO> listDto = new ArrayList<PagoDTO>();
		for (PagoEntity l : listL) {
			listDto.add(l.toDTO());
		}
		return listDto;
	}

	public Optional<PagoDTO> findById(int id) {
		Optional<PagoEntity> lo = data.findById(id);
		PagoEntity l = lo.get();
		PagoDTO dto = l.toDTO();
		return Optional.ofNullable(dto);
	}

	public PagoDTO save(PagoDTO dto) {
		PagoEntity l = data.save(dto.toEntity());
		return l.toDTO();
	}

	public void delete(PagoDTO i) {
		data.delete(i.toEntity());
	}
	
    

}