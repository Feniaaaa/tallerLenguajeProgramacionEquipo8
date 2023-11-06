package com.example.demo.backend.equipo8.dto;



import javax.validation.constraints.NotBlank;

import com.example.demo.backend.equipo8.entity.BoletaEntity;
import com.example.demo.backend.equipo8.entity.TipoDeBoletaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaDTO{
	private int id;

	@NotBlank
	private String monto;

	@NotBlank
	private String fecha;
	
	@NotBlank
	private String tipoboleta_id;
	
	
	public BoletaEntity toEntity() {
		BoletaEntity e = new BoletaEntity();
		TipoDeBoletaEntity t = new TipoDeBoletaEntity();
		e.setId(this.getId());
		e.setMonto(this.getMonto());
		e.setFecha(this.getFecha());
		t.setTipoboleta(this.getTipoboleta_id());
		return e;
	}
}
