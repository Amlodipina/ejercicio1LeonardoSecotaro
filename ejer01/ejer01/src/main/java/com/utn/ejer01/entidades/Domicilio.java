package com.utn.ejer01.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="Domicilio")
public class Domicilio extends BaseEntidad {
    @Id
    @GeneratedValue()
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
/*@OneToOne(mappedBy = "domicilio")
    private Cliente cliente;*/
    /*@ManyToOne()
    @JoinColumn(name = "Cliente_id")
    private Cliente cliente;
*/
}
