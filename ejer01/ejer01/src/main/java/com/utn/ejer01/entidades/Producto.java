package com.utn.ejer01.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto implements Serializable {
    @Id
    @GeneratedValue()
    private  Long id;
    private String tipoProducto;
    private int tiempoEstimadoCocina;
    private String denominacionProducto;
    private double precioCompra;
    private double precioVente;
    private int stockActual;
    private int stockMinimo;
    private double descuento;
    private String unidadMedida;
    private String receta;


}
