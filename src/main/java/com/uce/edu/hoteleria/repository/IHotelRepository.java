package com.uce.edu.hoteleria.repository;

import java.util.List;

import com.uce.edu.hoteleria.repository.modelo.Hotel;

public interface IHotelRepository {

	public Hotel seleccionar(Integer id);

	public void insertar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	public List<Hotel> seleccionarInnerJoin(); 

	public List<Hotel> seleccionarRightJoin(); 
	
	public List<Hotel> seleccionarLeftJoin(); 
	
	public List<Hotel> seleccionarFullJoin(); 

}
