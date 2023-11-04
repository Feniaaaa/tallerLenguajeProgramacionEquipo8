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


    public PagoEntity(@JsonProperty("id") int id) {
        super();
        this.id = id;

    }

}
