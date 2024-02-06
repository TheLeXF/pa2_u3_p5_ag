package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IClienteService;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5AgApplication implements CommandLineRunner {

	@Autowired 
	private IFacturaService facturaService;
	
//	@Autowired
//	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		Factura fact=new Factura();
		fact.setCedula("17274553");
		fact.setFecha(LocalDateTime.now());
		fact.setNumero("001-005");
		
		
		Cliente c1 = new Cliente();
		c1.setNombre("Santiago");
		c1.setApellido(null);
		
		//this.facturaService.guardar(fact,c1);
		System.out.println("Main: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.facturaService.prueba();
		
	}

}
