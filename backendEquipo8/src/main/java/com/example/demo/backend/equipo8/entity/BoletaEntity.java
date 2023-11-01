package com.example.demo.backend.equipo8.entity;

import com.example.demo.backend.equipo8.dto.BoletaDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="boletas")
public class BoletaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "monto")
    private int monto;
    
    @NotBlank
    @Column(name = "fecha")
    private Date fecha;
    
    @NotBlank
    @Column(name = "metodo_pago")
    private String metodo_pago;


    public BoletaEntity(@JsonProperty("id") int id,@JsonProperty("monto") int monto, @JsonProperty("fecha") Date fecha) {
        super();
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }
    
	public BoletaDTO toDTO() {
		BoletaDTO dto = new BoletaDTO();
		dto.setId(this.getId());
		dto.setMonto(this.getMonto());
		dto.setFecha(this.getFecha());
		dto.setMetodo_pago(this.getMetodo_pago());
		return dto;
	}
}

