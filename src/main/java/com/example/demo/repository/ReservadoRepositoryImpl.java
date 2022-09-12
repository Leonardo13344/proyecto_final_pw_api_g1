package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Reservado;
import com.example.demo.repository.model.Vehiculo;

@Repository
@Transactional
public class ReservadoRepositoryImpl implements IReservadoRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Reservado reservado) {
		// TODO Auto-generated method stub
		this.em.persist(reservado);
	}

	@Override
	public Reservado find(Integer id) {
		// TODO Auto-generated method stub
		return this.em.find(Reservado.class,id);
	}

	@Override
	public List<Reservado> findAll(LocalDate fechaI, LocalDate fechaF) {
		// TODO Auto-generated method stub
		TypedQuery<Reservado> myQuery = this.em
				.createQuery("SELECT v FROM Reservado v WHERE v.fechaInicio BETWEEN :fechaI AND :fechaF", Reservado.class);
		myQuery.setParameter("fechaI", fechaI);
		myQuery.setParameter("fechaF", fechaF);
		return myQuery.getResultList();
	}

	@Override
	public void update(Reservado reservado) {
		// TODO Auto-generated method stub
		this.em.merge(reservado);
	}

}
