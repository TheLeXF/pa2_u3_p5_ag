package com.uce.edu.deber.service;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Ciudadano;

public interface ICiudadanoService {
	public List<Ciudadano> buscarCiudadanoInfo();

	public List<Ciudadano> buscarCiudadanoEmpl();

	public List<Ciudadano> buscarCiudadano();

	public List<Ciudadano> buscarCiudadanoCompleto();

	public List<Ciudadano> buscarCiudadanoCompletoInfo();
	
}
