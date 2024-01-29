package com.uce.edu.hoteleria.repository;

import java.util.List;

import com.uce.edu.hoteleria.repository.modelo.Hotel;

public interface IHotelRepository {

	public Hotel seleccionar(Integer id);

	public void insertar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	public List<Hotel> seleccionarInnerJoin(String nombre); 

	public List<Hotel> seleccionarRightJoin(String direccion); 
	
	public List<Hotel> seleccionarLeftJoin(String clase); 
	
	public List<Hotel> seleccionarFullJoin(String noHabitacion); 

}
