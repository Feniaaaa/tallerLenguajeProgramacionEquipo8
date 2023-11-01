package com.example.demo.backend.equipo8.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="venta")
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "fecha")
    private Date fecha;
    
    @OneToMany
    @JoinColumn(name = "venta_detalle")
    List<DetalleEntity> detalle;
    
    @ManyToOne
    @JoinColumn(name = "idPago")
    PagoEntity idPago;
    
    @NotBlank
    @Column(name = "codigo_descuento")
    private String codigo_descuento;



    public VentaEntity(@JsonProperty("id") int id,@JsonProperty("fecha") Date fecha, 
    		@JsonProperty("venta_detalle") List<DetalleEntity> detalle, @JsonProperty("idPago") PagoEntity idPago,
    		@JsonProperty("codigo_descuento") String codigo_descuento){
        super();
        this.id = id;
        this.fecha = fecha;
        this.detalle = detalle;
        this.idPago = idPago;
        this.codigo_descuento = codigo_descuento;
    }
}