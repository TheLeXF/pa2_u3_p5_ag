package com.uce.edu.deber.repository;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {

	public List<Ciudadano> seleccionarCiudadanoInfo();

	public List<Ciudadano> seleccionarCiudadanoEmpl();

	public List<Ciudadano> seleccionarCiudadano();

	public List<Ciudadano> seleccionarCiudadanoCompleto();

	public List<Ciudadano> seleccionarCiudadanoCompletoInfo();

}
