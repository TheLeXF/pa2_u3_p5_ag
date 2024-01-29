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
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> buscararRightJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarRightJoin();
	}

	@Override
	public List<Hotel> buscarLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarLeftJoin();
	}

	@Override
	public List<Hotel> buscarFullJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarFullJoin();
	}

}
