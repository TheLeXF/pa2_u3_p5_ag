package com.uce.edu.deber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deber.repository.IAutorRepository;
import com.uce.edu.deber.repository.modelo.Autor;
@Service
public class AutorServiceImpl implements IAutorService{
	
	@Autowired
	private IAutorRepository autorRepository;
	
	@Override
	public List<Autor> buscarAutoInfo() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorInfo();
	}

	@Override
	public List<Autor> buscarAutorLibro() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorLibro();
	}

	@Override
	public List<Autor> buscarAutor() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutor();
	}

	@Override
	public List<Autor> buscarAutorCompleto() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorCompleto();
	}

	@Override
	public List<Autor> buscarAutorCompletoInfo() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorCompletoInfo();
	}

}
