package com.example.demo.backend.equipo8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.backend.equipo8.entity.LocalidadEntity;

@Repository
public interface ILocalidadRepository extends CrudRepository<LocalidadEntity, Integer> {
	
	//UsuarioEntity findBylogin(String login);
}
