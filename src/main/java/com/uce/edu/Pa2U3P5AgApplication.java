package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.hoteleria.repository.modelo.Habitacion;
import com.uce.edu.hoteleria.repository.modelo.Hotel;
import com.uce.edu.hoteleria.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5AgApplication implements CommandLineRunner {
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("JOIN - INNER JOIN");
		List<Hotel>lista = this.hotelService.buscarInnerJoin();
		for(Hotel h :lista) {
			System.out.println(h);
		}
		
		System.out.println("RIGHT JOIN ");
		
		List<Hotel>lista2 = this.hotelService.buscararRightJoin();
		for(Hotel h :lista2) {
			System.out.println(h);
		}
		System.out.println("LEFT JOIN");
		List<Hotel>lista3 = this.hotelService.buscarLeftJoin();
		for(Hotel h :lista3) {
			System.out.println(h);
		}
		
		System.out.println("FULL JOIN");
		List<Hotel>lista4 = this.hotelService.buscarFullJoin();
		for(Hotel h :lista4) {
			System.out.println(h);
			for (Habitacion d: h.getHabitaciones()) {
				System.out.println(d);
			}
		}
		
		
	}
	

}
