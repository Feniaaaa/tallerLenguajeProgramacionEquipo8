package com.example.demo.backend.equipo8.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@NoArgsConstructor
@Entity
@Table(name="pagos")
public class PagoEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pago_boleta")
    BoletaEntity boleta;
    

    public PagoEntity(@JsonProperty("id") int id,@JsonProperty("boleta") BoletaEntity boleta) {
        super();
        this.id = id;
        this.boleta = boleta;

    }

}
