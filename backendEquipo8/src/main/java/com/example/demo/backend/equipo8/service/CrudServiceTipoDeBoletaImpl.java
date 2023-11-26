package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.TipoDeBoletaDTO;
import com.example.demo.backend.equipo8.entity.TipoDeBoletaEntity;
import com.example.demo.backend.equipo8.repository.TipoDeBoletaRepository;


@Component
@Service
public class CrudServiceTipoDeBoletaImpl implements ICrudServiceTipoDeBoleta{

	@Autowired
	private TipoDeBoletaRepository data;
	

	public List<TipoDeBoletaDTO> findAll() {
		List<TipoDeBoletaEntity> listE = (List<TipoDeBoletaEntity>) data.findAll();
		List<TipoDeBoletaDTO> listDto = new ArrayList<TipoDeBoletaDTO>();
		for (TipoDeBoletaEntity e : listE) {
			listDto.add(e.toDTO());
		}
		return listDto;
	}
	
	public Optional<TipoDeBoletaDTO> findById(int id) {
		Optional<TipoDeBoletaEntity> oe = data.findById(id);
		TipoDeBoletaEntity e = oe.get();
		TipoDeBoletaDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
	}
	

	public TipoDeBoletaDTO save(TipoDeBoletaDTO dto) {
		TipoDeBoletaEntity e = data.save(dto.toEntity());
		
		return e.toDTO();
	}
	
	public void delete(TipoDeBoletaDTO p) {
		data.delete(p.toEntity());
	}

}
