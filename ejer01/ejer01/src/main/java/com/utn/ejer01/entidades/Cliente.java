package com.utn.ejer01.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="Cliente")
public class Cliente extends BaseEntidad {
    @Id
    @GeneratedValue()
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String telCliente;





   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;*/

  /*  @OneToMany(mappedBy = "Cliente", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @Builder.Default
    private List<pedido> pedidos = new ArrayList<>();*/

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();
    public void setDomicilio(Domicilio domi){
        domicilios.add(domi);
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @JoinColumn(name = "Cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    public void setPedido(Pedido pedi){
        pedidos.add(pedi);
    }

}

