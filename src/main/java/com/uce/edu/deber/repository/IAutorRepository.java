package com.uce.edu.deber.repository;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Autor;

public interface IAutorRepository {

	public List<Autor> seleccionarAutorInfo();

	public List<Autor> seleccionarAutorLibro();

	public List<Autor> seleccionarAutor();

	public List<Autor> seleccionarAutorCompleto();

	public List<Autor> seleccionarAutorCompletoInfo();
		
}
