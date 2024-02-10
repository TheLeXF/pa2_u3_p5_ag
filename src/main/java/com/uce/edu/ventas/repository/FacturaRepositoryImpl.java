package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f From Factura f WHERE f.numero=: numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetalleFactura().size();// Le digo que carge el detalle bajo demanda
		return fact;
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarInnerJoin() {
		// TODO Auto-generated method stub
		// En SQL: select *from factura f inner join detalle_factura d on
		// f.fact_id=d.defa_id_factura
		//
		// select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from
		// factura f1_0 join detalle_factura df1_0 on f1_0.fact_id=df1_0.defa_id_factura
		//
		// Aqui pongo la referencia que se encuentra en factura
		// En JPQL: SELECT * FROM Factura f INNER JOIN f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalleFactura d",
				Factura.class);
		List<Factura> list = myQuery.getResultList();
//		for (Factura f : list) {
//			f.getDetalleFactura().size();
//		}
		return list;
	}

	@Override
	public List<Factura> seleccionarRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFactura d", Factura.class);
		List<Factura> list = myQuery.getResultList();
		for (Factura f : list) {
			f.getDetalleFactura().size();
		}
		return list;
	}

	@Override
	public List<Factura> seleccionarLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFactura d", Factura.class);
		List<Factura> list = myQuery.getResultList();
		for (Factura f : list) {
			f.getDetalleFactura().size();
		}
		return list;
	}

	@Override
	public List<Factura> seleccionarFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFactura d", Factura.class);
		List<Factura> list = myQuery.getResultList();
		for (Factura f : list) {
			f.getDetalleFactura().size();
		}
		return list;
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Factura> seleccionarFacturaWhereJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id =
		// d.defa_id_factura
		// JPQL: SELECT f FROM Factura f, DetalleFactura d WHERE f =: d.factura
		// Hibernate :
		// Hibernate: select
		// f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from factura
		// f1_0,detalle_factura df1_0 where f1_0.fact_id=df1_0.defa_id_factura
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
		List<Factura> list = myQuery.getResultList();
		for (Factura f : list) {
			f.getDetalleFactura().size();// Señal
		}
		return list;

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Factura> seleccionarFacturaFetchJoin() {
		// TODO Auto-generated method stub
		// JPQL FECTH: SELECT f FROM Factura f JOIN FECTH f.detalleFactura d
		// JPQL INNERJOIN: SELECT f FROM Factura f JOIN f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalleFactura d", Factura.class);
		return myQuery.getResultList();
	}
	@Transactional(value = TxType.MANDATORY)
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		// SELECT * FROM Factura f WHERE fecha >= fechaActual
		// Lista
		// Recorrer la lista
		// Por cada factura seteo la nueva fecha
		// Actualizar cada factura
		// SQL : UPDATE factura set fact_fecha =:fechaNueva WHERE fact_fecha >=
		// fechaActual
		// JPQL: UPDATE Factura f SET f.fecha =:fechaNueva WHERE f.fecha >=:fechaActual
		Query myQuery = this.entityManager
				.createQuery("UPDATE Factura f SET f.fecha =:fechaNueva WHERE f.fecha  >=:fechaActual");
		myQuery.setParameter("fechaNueva", fechaNueva);
		myQuery.setParameter("fechaActual", fechaActual);
		// Cantidad de registros afectados/ actualizados
		return myQuery.executeUpdate();
	}
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		// SQL: DELETE FROM factura WHERE fact_numero =:numero
		// JPQL: DELETE FROM Factura f WHERE f.numero =:numero
		Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero =:numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED	)
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero, f.fecha) FROM Factura f",
				FacturaDTO.class);
//		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery(
//				"SELECT f.numero, f.fecha FROM Factura f",
//				FacturaDTO.class); Este tipo de query hace que trabaje mas hibernate al tratar de interpretar
		return myQuery.getResultList();
	}

}
