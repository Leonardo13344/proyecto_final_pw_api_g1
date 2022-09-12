package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.model.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insertC(Cliente cliente) {
		// TODO Auto-generated method stub
		cliente.setRegistro("C");
		this.em.persist(cliente);
	}

	@Override
	public Cliente find(Integer id) {
		// TODO Auto-generated method stub
		return this.em.find(Cliente.class, id);
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		this.em.merge(cliente);
	}

	@Override
	public void insertE(Cliente cliente) {
		// TODO Auto-generated method stub
		cliente.setRegistro("E");
		this.em.persist(cliente);
	}

	@Override
	public Cliente findByCedula(String cedulaD) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myQuery = this.em
				.createQuery("SELECT v FROM Cliente v WHERE v.cedula =: cedulaD", Cliente.class);
		myQuery.setParameter("cedulaD", cedulaD);
		return myQuery.getResultList().isEmpty() ? null : myQuery.getSingleResult();
	}

}
