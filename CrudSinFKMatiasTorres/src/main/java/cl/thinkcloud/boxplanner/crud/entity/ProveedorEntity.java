package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="proveedor")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotBlank
    @Column(name = "compania")
    private String compania;
    
    @Column(name = "telefono")
    private int telefono;
    
	

    public ProveedorEntity(@JsonProperty("id") int id,@JsonProperty("compania") String compania, @JsonProperty("telefono") int telefono) {
        super();
        this.id = id;
        this.compania = compania;
        this.telefono = telefono;
        
    }
}
