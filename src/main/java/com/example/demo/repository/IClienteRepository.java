package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Cliente;

public interface IClienteRepository {
	
	public void insertC(Cliente cliente);
	public void insertE(Cliente cliente);
	public Cliente find(Integer id);
	public void update(Cliente cliente);
	public Cliente findByCedula(String cedula);
	public List<Cliente> findAll();

}
