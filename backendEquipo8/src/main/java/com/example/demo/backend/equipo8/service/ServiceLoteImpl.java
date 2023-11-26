package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.LoteDTO;
import com.example.demo.backend.equipo8.entity.LoteEntity;
import com.example.demo.backend.equipo8.repository.ILoteRepository;



@Component
@Service
public class ServiceLoteImpl implements IServiceLote {

	@Autowired
	private ILoteRepository data;
	

	public List<LoteDTO> findAll() {
		List<LoteEntity> listE = (List<LoteEntity>) data.findAll();
		List<LoteDTO> listDto = new ArrayList<LoteDTO>();
		for (LoteEntity e : listE) {
			listDto.add(e.toDTO());
		}
		return listDto;
	}
	
	public Optional<LoteDTO> findById(int id) {
		Optional<LoteEntity> oe = data.findById(id);
		LoteEntity e = oe.get();
		LoteDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
	}
	

	public LoteDTO save(LoteDTO dto) {
		LoteEntity e = data.save(dto.toEntity());
		
		return e.toDTO();
	}
	
	public void delete(LoteDTO p) {
		data.delete(p.toEntity());
	}

}