package com.example.demo.backend.equipo8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.backend.equipo8.entity.ProductoEntity;

@Repository
public interface IProductoRepository extends CrudRepository<ProductoEntity, Integer> {
	

}
