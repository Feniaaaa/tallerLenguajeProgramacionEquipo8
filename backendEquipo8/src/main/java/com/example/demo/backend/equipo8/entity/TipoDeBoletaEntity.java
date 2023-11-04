package com.example.demo.backend.equipo8.entity;



import com.example.demo.backend.equipo8.dto.TipoDeBoletaDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="tipoboleta")
public class TipoDeBoletaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "tipoboleta")
    private String tipoboleta;
    
    


    public TipoDeBoletaEntity(@JsonProperty("id") int id,@JsonProperty("tipoboleta") String tipoboleta) {
        super();
        this.id = id;
        this.tipoboleta = tipoboleta;
    }
    
	public TipoDeBoletaDTO toDTO() {
		TipoDeBoletaDTO dto = new TipoDeBoletaDTO();
		dto.setId(this.getId());
		dto.setTipoboleta(this.getTipoboleta());
		return dto;
	}
}
