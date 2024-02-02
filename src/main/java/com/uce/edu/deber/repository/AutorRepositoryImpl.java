package com.uce.edu.deber.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deber.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Autor> seleccionarAutorInfo() {
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a JOIN a.libros l", Autor.class);

		List<Autor> a1 = myQuery.getResultList();
		for (Autor a : a1) {
			a.getLibros().size();
		}
		return a1;
	}

	@Override
	public List<Autor> seleccionarAutorLibro() {
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a RIGHT JOIN a.libros l", Autor.class);

		List<Autor> a1 = myQuery.getResultList();
		for (Autor a : a1) {
			a.getLibros().size();
		}
		return a1;
	}

	@Override
	public List<Autor> seleccionarAutor() {
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a LEFT JOIN a.libros l", Autor.class);

		List<Autor> a1 = myQuery.getResultList();
		for (Autor a : a1) {
			a.getLibros().size();
		}
		return a1;
	}

	@Override
	public List<Autor> seleccionarAutorCompleto() {
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a FULL JOIN a.libros l", Autor.class);

		List<Autor> a1 = myQuery.getResultList();
		for (Autor a : a1) {
			a.getLibros().size();
		}
		return a1;
	}

	@Override
	public List<Autor> seleccionarAutorCompletoInfo() {
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a JOIN FETCH a.libros l", Autor.class);

		List<Autor> a1 = myQuery.getResultList();
		for (Autor a : a1) {
			a.getLibros().size();
		}
		return a1;
	}

}
