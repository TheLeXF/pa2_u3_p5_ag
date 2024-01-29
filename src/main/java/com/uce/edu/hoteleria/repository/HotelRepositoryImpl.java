package com.uce.edu.hoteleria.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.hoteleria.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel h1 = this.seleccionar(id);
		this.entityManager.remove(h1);
	}

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones b",
				Hotel.class);
		List<Hotel> list = myQuery.getResultList();
		for (Hotel h1 : list) {
			h1.getHabitaciones().size();

		}
		return list;
	}

	@Override
	public List<Hotel> seleccionarRightJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones b",
				Hotel.class);
		List<Hotel> list = myQuery.getResultList();
		for (Hotel h1 : list) {
			h1.getHabitaciones().size();

		}
		return list;
	}

	@Override
	public List<Hotel> seleccionarLeftJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones b",
				Hotel.class);
		List<Hotel> list = myQuery.getResultList();
		for (Hotel h1 : list) {
			h1.getHabitaciones().size();

		}
		return list;
	}

	@Override
	public List<Hotel> seleccionarFullJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones b",
				Hotel.class);
		List<Hotel> list = myQuery.getResultList();
		for (Hotel h1 : list) {
			h1.getHabitaciones().size();

		}
		return list;
	}

}
