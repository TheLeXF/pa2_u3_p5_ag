package com.uce.edu.deber.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deber.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Ciudadano> seleccionarCiudadanoInfo() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c JOIN c.empleado e", Ciudadano.class);
		List<Ciudadano> c1 = myQuery.getResultList();
		for (Ciudadano c : c1) {
			c.getCedula().length();
		}
		return c1;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanoEmpl() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c RIGHT JOIN  c.empleado e", Ciudadano.class);
		List<Ciudadano> c1 = myQuery.getResultList();
		for (Ciudadano c : c1) {
			c.getCedula().length();
		}
		return c1;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadano() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c LEFT JOIN c.empleado e", Ciudadano.class);
		List<Ciudadano> c1 = myQuery.getResultList();
		for (Ciudadano c : c1) {
			c.getCedula().length();
		}
		return c1;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanoCompleto() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c FULL JOIN c.empleado e", Ciudadano.class);
		List<Ciudadano> c1 = myQuery.getResultList();
		for (Ciudadano c : c1) {
			c.getCedula().length();
		}
		return c1;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanoCompletoInfo() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c JOIN FETCH c.empleado e", Ciudadano.class);
		List<Ciudadano> c1 = myQuery.getResultList();
		for (Ciudadano c : c1) {
			c.getCedula().length();
		}
		return c1;
	}

}
