package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
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
		
		System.out.println("UPDATE");
		
		int cantidad = this.facturaService.actualizarFechas(LocalDateTime.of(2020, 1, 9, 12, 50),
				LocalDateTime.of(2020, 1, 15, 12, 0));
		System.out.println("Cantidad de registros / fila actualizados");
		System.out.println(cantidad);
		

		System.out.println("DELETE");
		
		int cantidad2 = this.facturaService.borrarPorNumero("0001-02570");
		System.out.println("Cantidad de registros / fila eliminados");
		System.out.println(cantidad2);
		
		//this.facturaService.eliminar(1);
		System.out.println("DTO");
		
		List<FacturaDTO>listDTO=this.facturaService.buscarFacturasDTO();
		for (FacturaDTO fac:listDTO) {
			System.out.println(fac);
		}
		
	}

}
