package com.example.demo.backend.equipo8.entity;

import com.example.demo.backend.equipo8.dto.CarritoDTO;
import com.example.demo.backend.equipo8.dto.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="carrito")
public class CarritoEntity {
    @Id
    private int id;
    
    @ElementCollection
    @CollectionTable(name = "carrito_compra", joinColumns = @JoinColumn(name = "carrito_id"))
    private List<String> carritoCompra;
    

    public CarritoEntity(@JsonProperty("id") int id,@JsonProperty("carritoCompra") List<String> carritoCompra) {
        super();
        this.id = id;
        this.carritoCompra = carritoCompra;
    }
    public CarritoDTO toDTO() {
    	CarritoDTO dto = new CarritoDTO();
		dto.setId(this.getId());
		dto.setCarritoCompra(this.getCarritoCompra());
		return dto;
	}
}