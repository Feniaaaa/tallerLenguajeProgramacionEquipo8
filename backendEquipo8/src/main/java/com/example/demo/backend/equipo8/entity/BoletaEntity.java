package com.example.demo.backend.equipo8.entity;

import com.example.demo.backend.equipo8.dto.BoletaDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="boleta")
public class BoletaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "monto")
    private String monto;
    
    @NotBlank
    @Column(name = "fecha")
    private String fecha;
    
    @OneToOne
    @JoinColumn(name="tipodeboleta_id")
    private TipoDeBoletaEntity tipoboleta;


    public BoletaEntity(@JsonProperty("id") int id,@JsonProperty("monto") String monto, @JsonProperty("fecha") String fecha) {
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
		return dto;
	}
}

