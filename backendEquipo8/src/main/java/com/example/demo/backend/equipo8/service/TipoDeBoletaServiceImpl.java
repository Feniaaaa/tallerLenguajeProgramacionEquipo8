package com.example.demo.backend.equipo8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.backend.equipo8.entity.TipoDeBoletaEntity;
import com.example.demo.backend.equipo8.repository.TipoDeBoletaRepository;

public class TipoDeBoletaServiceImpl implements ITipoDeBoletaService{

	@Autowired
	private TipoDeBoletaRepository data;
	
	@Override
	public List<TipoDeBoletaEntity> ListaTipoDeBoleta(){
			
		return (List<TipoDeBoletaEntity>) data.findAll();
	}
}
