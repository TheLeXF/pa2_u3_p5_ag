package com.uce.edu.deber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deber.repository.ICiudadanoRepository;
import com.uce.edu.deber.repository.modelo.Ciudadano;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService{

	@Autowired
	 private ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public List<Ciudadano> buscarCiudadanoInfo() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoInfo();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoEmpl() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoEmpl();
	}

	@Override
	public List<Ciudadano> buscarCiudadano() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadano();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoCompleto() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoCompleto();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoCompletoInfo() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoCompletoInfo();
	}

}
