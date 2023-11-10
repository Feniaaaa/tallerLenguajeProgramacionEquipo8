package cl.thinkcloud.boxplanner.crud.entity;

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



    public BoletaEntity(@JsonProperty("id") int id,@JsonProperty("monto") String monto, @JsonProperty("fecha") String fecha) {
        super();
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }

}
