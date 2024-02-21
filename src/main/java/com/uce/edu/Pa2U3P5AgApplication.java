package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.service.IClienteService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P5AgApplication implements CommandLineRunner {

	@Autowired
	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Nombre Hilo" + Thread.currentThread().getName());
		long tiempoIniciaL = System.currentTimeMillis();
		for (int i = 0; i <= 500; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			if (cliente.getNombre().startsWith("E")) {
				this.clienteService.guardar(cliente);
			}
			

			
			
		}
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoIniciaL) / 1000;

		System.out.println("Tiempo trasncurrido en segundos: " + tiempoTranscurrido);
		System.out.println("Se ha mandado a procesar sus 500 clientes, puede continuar con sus actividades");
		// Tiempo Transcurrido en seg 105

		// Programacion en paralelo (multihilo-MultiThread)
//		System.out.println("Nombre Hilo"+Thread.currentThread().getName()); 
//		long tiempoIniciaL = System.currentTimeMillis();
//		List<Cliente> listaClientes = new ArrayList<>();
//		for (int i = 0; i <= 100; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			listaClientes.add(cliente);
//		}
//		listaClientes.stream().forEach(cliente -> this.clienteService.guardar(cliente));
//		long tiempoFinal = System.currentTimeMillis();
//
//		long tiempoTranscurrido = (tiempoFinal - tiempoIniciaL) / 1000;
//		System.out.println("Tiempo trasncurrido en segundos: "+tiempoTranscurrido);
		// Tiempo Transcurrido en seg; 101

//		System.out.println("Nombre Hilo"+Thread.currentThread().getName()); 
//		long tiempoIniciaL = System.currentTimeMillis();
//		List<Cliente> listaClientes = new ArrayList<>();
//		for (int i = 0; i <= 100; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			listaClientes.add(cliente);
//		}
//		listaClientes.parallelStream().forEach(cliente -> this.clienteService.guardar(cliente));
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (tiempoFinal - tiempoIniciaL) / 1000;
//		System.out.println("Tiempo trasncurrido en segundos: "+tiempoTranscurrido);
	}

}
