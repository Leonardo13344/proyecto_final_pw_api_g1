package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Vehiculo;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.em.persist(vehiculo);
	}

	@Override
	public Vehiculo find(Integer id) {
		// TODO Auto-generated method stub
		return this.em.find(Vehiculo.class, id);
	}

	@Override
	public void update(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.em.merge(vehiculo);
	}

	@Override
	public List<Vehiculo> findVehiD(String marcaD, String modeloD) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.em
				.createQuery("SELECT v FROM Vehiculo v WHERE v.marca =: marcaD AND v.modelo =: modeloD", Vehiculo.class);
		myQuery.setParameter("marcaD", marcaD);
		myQuery.setParameter("modeloD", modeloD);
		return myQuery.getResultList();
	}

	@Override
	public Vehiculo findVehiByPlaca(String placaD) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.em
				.createQuery("SELECT v FROM Vehiculo v WHERE v.placa =: placaD", Vehiculo.class);
		myQuery.setParameter("placaD", placaD);
		return myQuery.getResultList().isEmpty() ? null : myQuery.getSingleResult();
	}

}
