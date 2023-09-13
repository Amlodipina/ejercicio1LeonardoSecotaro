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
public class Pedido implements Serializable{
    @Id
    @GeneratedValue()
    private Long id;
    private String Estado;
    private String fechaPedido;
    private String tipoEnvio;
    private double total;

   /* public void setDetallePedido(DetallePedido Depedi){
        detallePedidos.add(Depedi);
    }*/

    @ManyToOne()
    @JoinColumn(name = "Cliente_id")
    private Cliente cliente;

   /* @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

    *//*@Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();*/

    @OneToOne(cascade = CascadeType.ALL)
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();
    public void setDetallePedido(DetallePedido dp){
        detallePedidos.add(dp);
    }

}
