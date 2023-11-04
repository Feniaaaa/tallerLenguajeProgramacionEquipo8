package com.example.demo.backend.equipo8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.backend.equipo8.entity.ProveedorEntity;

@Repository
public interface IProveedorRepository extends CrudRepository<ProveedorEntity, Integer> {
	
	//UsuarioEntity findBylogin(String login);
}
