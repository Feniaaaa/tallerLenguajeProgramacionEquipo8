package com.example.demo.frontend.equipo8.dto;


import javax.validation.constraints.NotBlank;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaDTO {
	private int id;

	@NotBlank
	private String monto;

	@NotBlank
	private String fecha;	
	
	private TipoDeBoletaDTO tipoboleta;
}
