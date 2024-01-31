package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {

	public Factura seleccionarPorNumero(String numero);
	
	public Factura buscar(Integer id);
	
	public void eliminar(Integer id);

	public void insertar(Factura factura);

	public List<Factura> seleccionarInnerJoin();

	public List<Factura> seleccionarRightJoin();

	public List<Factura> seleccionarLeftJoin();

	public List<Factura> seleccionarFullJoin();

	public List<Factura> seleccionarFacturaWhereJoin();

	public List<Factura> seleccionarFacturaFetchJoin();

	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	
	public int eliminarPorNumero(String numero);
	
	public List<FacturaDTO> seleccionarFacturasDTO();
	
}
