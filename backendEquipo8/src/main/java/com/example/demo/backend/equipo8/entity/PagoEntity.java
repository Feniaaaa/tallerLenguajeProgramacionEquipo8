package com.example.demo.backend.equipo8.entity;
import com.example.demo.backend.equipo8.dto.PagoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Data
@NoArgsConstructor
@Entity
@Table(name="pagos")
public class PagoEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    @Column(name = "metodoPago")
    private String metodoPago;

    public PagoEntity(@JsonProperty("id") int id) {
        super();
        this.id = id;

    }
    
    public PagoDTO toDTO() {
		PagoDTO dto = new PagoDTO();
		dto.setId(this.getId());
		dto.setMetodoPago(this.getMetodoPago());
		return dto;
	}

}
