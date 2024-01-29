package com.uce.edu.hoteleria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.hoteleria.repository.IHotelRepository;
import com.uce.edu.hoteleria.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionar(id);
	}

	@Override
	public void agregar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.actualizar(hotel);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.hotelRepository.eliminar(id);
	}

	@Override
	public List<Hotel> buscarInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarInnerJoin(nombre);
	}

	@Override
	public List<Hotel> buscararRightJoin(String direccion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarRightJoin(direccion);
	}

	@Override
	public List<Hotel> buscarLeftJoin(String clase) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarLeftJoin(clase);
	}

	@Override
	public List<Hotel> buscarFullJoin(String noHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarFullJoin(noHabitacion);
	}

}
