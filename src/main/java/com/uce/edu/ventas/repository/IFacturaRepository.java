package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaRepository {

	public Factura seleccionarPorNumero(String numero);

	public void insertar(Factura factura);
	
	public List<Factura> seleccionarInnerJoin(); 

	public List<Factura> seleccionarRightJoin(); 
	
	public List<Factura> seleccionarLeftJoin(); 
	
	public List<Factura> seleccionarFullJoin(); 
	
}
