package com.example.demo.backend.equipo8.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="lote")
public class LoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;
    
    @NotBlank
    @Column(name = "litros")
    private int litros;
    
    @NotBlank
    @Column(name = "fechaVencimiento")
    private Date fechaVencimiento;



    public LoteEntity(@JsonProperty("id") int id,@JsonProperty("nombre") String nombre, @JsonProperty("litros") int litros, @JsonProperty("fechaVencimiento") Date fechaVencimiento) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.litros = litros;
        this.fechaVencimiento = fechaVencimiento;
    }
}