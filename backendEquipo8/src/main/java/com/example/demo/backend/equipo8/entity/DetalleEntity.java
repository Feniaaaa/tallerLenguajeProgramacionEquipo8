package com.example.demo.backend.equipo8.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="detalle")
public class DetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    ProductoEntity idProducto;
    
    @NotBlank
    @Column(name = "cantidad")
    private int cantidad;



    public DetalleEntity(@JsonProperty("id") int id,@JsonProperty("idProducto") ProductoEntity idProducto, @JsonProperty("cantidad") int cantidad) {
        super();
        this.id = id;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }
}