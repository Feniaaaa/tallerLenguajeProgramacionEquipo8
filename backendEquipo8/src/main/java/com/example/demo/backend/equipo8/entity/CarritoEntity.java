package com.example.demo.backend.equipo8.entity;

import com.example.demo.backend.equipo8.dto.CarritoDTO;
import com.example.demo.backend.equipo8.dto.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name="carrito")
public class CarritoEntity {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;
    

    public CarritoEntity(@JsonProperty("id") int id) {
        super();
        this.id = id;
    }
    public CarritoDTO toDTO() {
    	CarritoDTO dto = new CarritoDTO();
		dto.setId(this.getId());
		return dto;
	}
}