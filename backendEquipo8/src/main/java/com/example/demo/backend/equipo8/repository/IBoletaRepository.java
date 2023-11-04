package com.example.demo.backend.equipo8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.backend.equipo8.entity.BoletaEntity;

@Repository
public interface IBoletaRepository extends CrudRepository<BoletaEntity, Integer> {
	
	//UsuarioEntity findBylogin(String login);
}
