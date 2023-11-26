package com.example.demo.frontend.equipo8.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoteDTO {
	
	private int id;

    private String nombre;
    
    private int litros;
    
    private Date fechaVencimiento;
}
