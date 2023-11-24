package com.example.demo.backend.equipo8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.backend.equipo8.entity.BoletaEntity;

@Repository
public interface IBoletaRepository extends CrudRepository<BoletaEntity, Integer> {
	

}
