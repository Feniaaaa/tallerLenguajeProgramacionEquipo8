package com.example.demo.backend.equipo8.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name="carrito")
public class CarritoEntity {
    @Id
    private int id;

    @OneToMany
    @JoinColumn(name = "producto")
    private ProductoEntity producto;


    public CarritoEntity(@JsonProperty("id") int id,@JsonProperty("producto") ProductoEntity producto) {
        super();
        this.id = id;
        this.producto = producto;
    }
}