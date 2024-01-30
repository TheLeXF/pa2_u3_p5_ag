package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.hoteleria.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5AgApplication implements CommandLineRunner {
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("WHERE JOIN");
		List<Factura>lista = this.facturaService.buscarFacturaWhereJoin();
		for(Factura f :lista) {
			System.out.println(f.getNumero());
			for(DetalleFactura d : f.getDetalleFactura()) {
				System.out.println(d.getNombreProducto());
			}
		}
		
		System.out.println("INNER JOIN");
		List<Factura>lista2 = this.facturaService.buscarFacturasInnerJoin();
		for(Factura f :lista2) {
			System.out.println(f.getNumero());
//			for(DetalleFactura d : f.getDetalleFactura()) {
//				System.out.println(d.getNombreProducto());
//			}
		}
		
		System.out.println("FECTH JOIN");
		List<Factura>lista3 = this.facturaService.buscarFacturaFetchJoin();
		for(Factura f :lista3) {
			System.out.println(f.getNumero());
			for(DetalleFactura d : f.getDetalleFactura()) {
				System.out.println(d.getNombreProducto());
			}
		}
		
		
		
	}

}
