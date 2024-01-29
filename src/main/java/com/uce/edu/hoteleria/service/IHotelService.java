package com.uce.edu.hoteleria.service;

import java.util.List;

import com.uce.edu.hoteleria.repository.modelo.Hotel;

public interface IHotelService {
	
	public Hotel buscar(Integer id);

	public void agregar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void borrar(Integer id);

	public List<Hotel> buscarInnerJoin(); 

	public List<Hotel> buscararRightJoin(); 
	
	public List<Hotel> buscarLeftJoin(); 
	
	public List<Hotel> buscarFullJoin(); 
}
