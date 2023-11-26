package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.BoletaDTO;
import com.example.demo.backend.equipo8.entity.BoletaEntity;
import com.example.demo.backend.equipo8.entity.TipoDeBoletaEntity;
import com.example.demo.backend.equipo8.repository.IBoletaRepository;




@Component
@Service
public class CrudServiceBoletaImpl implements ICrudServiceBoleta {

	@Autowired
	private IBoletaRepository data;

	public List<BoletaDTO> findAll() {
		List<BoletaEntity> listE = (List<BoletaEntity>) data.findAll();
		List<BoletaDTO> listDto = new ArrayList<>();
		for (BoletaEntity e : listE) {
            BoletaDTO boletaDTO = e.toDTO();
            TipoDeBoletaEntity tipoboletaEntity = e.getTipoboleta();
            if (tipoboletaEntity != null) {
                boletaDTO.setTipoboleta(tipoboletaEntity.toDTO());
            }
            listDto.add(boletaDTO);
        }
        return listDto;
    }

	public Optional<BoletaDTO> findById(int id) {
		Optional<BoletaEntity> oe = data.findById(id);
		BoletaEntity e = oe.get();
		BoletaDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
	}

	public BoletaDTO save(BoletaDTO dto) {
		BoletaEntity e = data.save(dto.toEntity());
		return e.toDTO();
	}

	public void delete(BoletaDTO p) {
		data.delete(p.toEntity());
	}
	
    

}