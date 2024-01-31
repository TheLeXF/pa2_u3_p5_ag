package com.uce.edu.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {

	public Factura buscarPorNumero(String numero);

	public void guardar(Factura factura);

	public List<Factura> buscarFacturasInnerJoin();

	public List<Factura> buscararRightJoin();

	public List<Factura> buscarLeftJoin();

	public List<Factura> buscarFullJoin();

	public List<Factura> buscarFacturaWhereJoin();

	public List<Factura> buscarFacturaFetchJoin();
	
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	
	public int borrarPorNumero(String numero);
	
	public void eliminar(Integer id);
	
	public List<FacturaDTO> buscarFacturasDTO();


}
