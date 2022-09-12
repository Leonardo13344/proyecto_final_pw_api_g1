package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Transaccion;

@Repository
@Transactional
public class TransaccionRepositoryImpl implements ITransaccionRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Transaccion transaccion) {
		// TODO Auto-generated method stub
		this.em.persist(transaccion);
	}

	@Override
	public void update(Transaccion transaccion) {
		// TODO Auto-generated method stub
		this.em.merge(transaccion);
	}

}
