package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.deber.repository.modelo.Autor;
import com.uce.edu.deber.repository.modelo.Ciudadano;
import com.uce.edu.deber.repository.modelo.Libro;
import com.uce.edu.deber.service.IAutorService;
import com.uce.edu.deber.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U3P5AgApplication implements CommandLineRunner {
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired 
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("INNER JOIN");
		List<Autor>lista = this.autorService.buscarAutoInfo();
		for(Autor a :lista) {
			System.out.println(a);
			for(Libro l : a.getLibros()) {
				System.out.println(l);
			}
		}
		
		List<Ciudadano>lista2 = this.ciudadanoService.buscarCiudadanoInfo();
		for(Ciudadano c :lista2) {
			System.out.println(c);
		}
		
		System.out.println("RIGHT JOIN");
		List<Autor>lista3 = this.autorService.buscarAutorLibro();
		for(Autor a :lista3) {
			System.out.println(a);
			for(Libro l : a.getLibros()) {
				System.out.println(l);
			}
		}
		
		List<Ciudadano>lista4 = this.ciudadanoService.buscarCiudadanoEmpl();
		for(Ciudadano c :lista4) {
			System.out.println(c);
		}
		
		System.out.println("LEFT JOIN");
		List<Autor>lista5 = this.autorService.buscarAutor();
		for(Autor a :lista5) {
			System.out.println(a);
			for(Libro l : a.getLibros()) {
				System.out.println(l);
			}
		}
		
		List<Ciudadano>lista6 = this.ciudadanoService.buscarCiudadano();
		for(Ciudadano c :lista6) {
			System.out.println(c);
		}
		
		
		System.out.println("FULL JOIN");
		List<Autor>lista7 = this.autorService.buscarAutorCompleto();
		for(Autor a :lista7) {
			System.out.println(a);
			for(Libro l : a.getLibros()) {
				System.out.println(l);
			}
		}
		
		List<Ciudadano>lista8 = this.ciudadanoService.buscarCiudadanoCompleto();
		for(Ciudadano c :lista8) {
			System.out.println(c);
		}
		
		System.out.println("FETCH JOIN");
		List<Autor>lista9 = this.autorService.buscarAutorCompletoInfo();
		for(Autor a :lista9) {
			System.out.println(a);
			for(Libro l : a.getLibros()) {
				System.out.println(l);
			}
		}
		
		List<Ciudadano>lista10 = this.ciudadanoService.buscarCiudadanoCompletoInfo();
		for(Ciudadano c :lista10) {
			System.out.println(c);
		}
		
	}

}
