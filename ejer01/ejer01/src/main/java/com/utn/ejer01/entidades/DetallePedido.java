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
public class DetallePedido implements Serializable {
    @Id
    @GeneratedValue()
    private  Long id;
    private int cantidad;
    private double subTotal;

  /*  @ManyToOne()
    @JoinColumn(name = "Pedido_id")
    private Pedido pedido;
*/
/*    @ManyToOne()
    @JoinColumn(name = "Producto_id")
    private Producto producto;*/

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "Producto_ID")
    private Producto producto;
}
