package com.uce.edu.deber.service;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Autor;

public interface IAutorService {
	
	public List<Autor> buscarAutoInfo();

	public List<Autor> buscarAutorLibro();

	public List<Autor> buscarAutor();

	public List<Autor> buscarAutorCompleto();

	public List<Autor> buscarAutorCompletoInfo();
}
