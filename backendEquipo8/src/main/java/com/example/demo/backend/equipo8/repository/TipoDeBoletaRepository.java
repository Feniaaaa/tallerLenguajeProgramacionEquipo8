package com.example.demo.backend.equipo8.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.backend.equipo8.dto.TipoDeBoletaDTO;
import com.example.demo.backend.equipo8.entity.TipoDeBoletaEntity;

public interface TipoDeBoletaRepository extends CrudRepository<TipoDeBoletaEntity, Integer> {
	
}
