package com.example.demo.backend.equipo8.entity;

import com.example.demo.backend.equipo8.dto.PagoDTO;
import com.example.demo.backend.equipo8.dto.PedidoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="pedido")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "fecha_envio")
    private Date fecha_envio;
    
    @NotBlank
    @Column(name = "estado")
    private String estado;



    public PedidoEntity(@JsonProperty("id") int id,@JsonProperty("fecha_envio") Date fecha_envio, @JsonProperty("estado") String estado) {
        super();
        this.id = id;
        this.fecha_envio = fecha_envio;
        this.estado = estado;
    }
    
    public PedidoDTO toDTO() {
		PedidoDTO dto = new PedidoDTO();
		dto.setId(this.getId());
		dto.setFecha_envio(this.getFecha_envio());
		dto.setEstado(this.getEstado());
		return dto;
	}
}