package com.utn.ejer01;

import com.utn.ejer01.entidades.*;
import com.utn.ejer01.repositorios.*;
import org.hibernate.metamodel.model.domain.internal.DomainModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class Ejer01Application {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;


	public static void main(String[] args) {
		SpringApplication.run(Ejer01Application.class, args);
		System.out.println("Anda");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo, DomicilioRepository domicilioRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository, DetallePedidoRepository detallePedidoRepository, FacturaRepository facturaRepository) {
		return args -> {
			System.out.println("------------Estoy funcionando pa-----------");

			Domicilio domicilio1 = Domicilio.builder()
					.calle("LosReyunos")
					.localidad("Guaymallen")
					.numero("30").build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Batata")
					.localidad("GodoyCruz")
					.numero("31").build();


			Cliente cliente = Cliente.builder()
					.edad(21)
					.telCliente("2615712839")
					.apellido("Messi")
					.nombre("Leo").build();

			Pedido pedido1= Pedido.builder()
					.total(4554.1)
					.fechaPedido("1/2/2023")
					.Estado("Entregado")
					.tipoEnvio("Delivery")
					.build();

			Pedido pedido2= Pedido.builder()
					.total(4553.1)
					.fechaPedido("1/1/2022")
					.Estado("Retirado")
					.tipoEnvio("Retiro")
					.build();

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(14)
					.subTotal(4515)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(15)
					.subTotal(4515)
					.build();
			Rubro rubro = Rubro.builder()
					.denominacionRubro("Pan")
					.build();

			Producto producto1 = Producto.builder()
					.tipoProducto("Manufacturada")
					.stockActual(10)
					.stockMinimo(1)
					.receta("Masa")
					.precioCompra(20)
					.precioVente(70)
					.denominacionProducto("Pan")
					.tiempoEstimadoCocina(5)
					.unidadMedida("kg")
					.build();

			Producto product2 = Producto.builder()
					.tipoProducto("Manufacturada")
					.stockActual(20)
					.stockMinimo(1)
					.receta("Masa")
					.precioCompra(10)
					.precioVente(50)
					.denominacionProducto("Pan")
					.tiempoEstimadoCocina(3)
					.unidadMedida("kg")
					.build();

			Factura factura = Factura.builder()
					.nroFactura(1234)
					.totalFactura(43242)
					.formaPago("efectivo")
					.descuento(50).
					fechaFactura("1/1/2023")
					.build();


			cliente.setDomicilio(domicilio1);
			cliente.setDomicilio(domicilio2);



			cliente.setPedido(pedido1);
			cliente.setPedido(pedido2);

			pedido1.setCliente(cliente);
			pedido2.setCliente(cliente);

			pedido1.setDetallePedido(detallePedido1);
			pedido1.setDetallePedido(detallePedido2);

		    rubro.setProductoR(producto1);
			rubro.setProductoR(product2);


			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto1);

            pedido1.setFactura(factura);
            factura.setPedido(pedido1);


			clienteRepository.save(cliente);
			facturaRepository.save(factura);
			productoRepository.save(producto1);
			productoRepository.save(product2);
			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			rubroRepository.save(rubro);



			};
		}

	}