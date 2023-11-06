package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.LocalidadDTO;
import com.example.demo.backend.equipo8.entity.LocalidadEntity;
import com.example.demo.backend.equipo8.repository.ILocalidadRepository;




@Component
@Service

public class CrudServiceLocalidadImpl implements ICrudServiceL {

	@Autowired
	private ILocalidadRepository data;

	public List<LocalidadDTO> findAll() {
		List<LocalidadEntity> listL = (List<LocalidadEntity>) data.findAll();
		List<LocalidadDTO> listDto = new ArrayList<LocalidadDTO>();
		for (LocalidadEntity l : listL) {
			listDto.add(l.toDTO());
		}
		return listDto;
	}

	public Optional<LocalidadDTO> findById(int id) {
		Optional<LocalidadEntity> lo = data.findById(id);
		LocalidadEntity l = lo.get();
		LocalidadDTO dto = l.toDTO();
		return Optional.ofNullable(dto);
	}

	public LocalidadDTO save(LocalidadDTO dto) {
		LocalidadEntity l = data.save(dto.toEntity());
		return l.toDTO();
	}

	public void delete(LocalidadDTO i) {
		data.delete(i.toEntity());
	}
	
    

}