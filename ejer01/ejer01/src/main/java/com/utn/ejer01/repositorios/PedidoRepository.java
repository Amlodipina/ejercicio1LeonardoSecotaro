package com.utn.ejer01.repositorios;

import com.utn.ejer01.entidades.Domicilio;
import com.utn.ejer01.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>  {
}
