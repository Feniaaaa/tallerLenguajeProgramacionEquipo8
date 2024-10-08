package com.example.demo.backend.equipo8.entity;

import com.example.demo.backend.equipo8.dto.BoletaDTO;
import com.example.demo.backend.equipo8.dto.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="producto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "precio")
    private int precio;
    
    @NotBlank
    @Column(name = "cantidad")
    private int cantidad;



    public ProductoEntity(@JsonProperty("id") int id,@JsonProperty("precio") int precio, @JsonProperty("cantidad") int cantidad) {
        super();
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public ProductoDTO toDTO() {
    	ProductoDTO dto = new ProductoDTO();
		dto.setId(this.getId());
		dto.setPrecio(this.getPrecio());
		dto.setCantidad(this.getCantidad());
		return dto;
	}
}