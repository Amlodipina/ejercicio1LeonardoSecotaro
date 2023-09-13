package com.utn.ejer01.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura {
    @Id
    @GeneratedValue()
    private  Long id;
    private int nroFactura;
    private String fechaFactura;
    private String formaPago;
    private int totalFactura;
    private double descuento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pedido_id")
    private Pedido pedido;

}
