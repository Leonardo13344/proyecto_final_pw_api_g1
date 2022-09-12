package com.example.demo.service;

import com.example.demo.repository.model.Cliente;

public interface IClienteService {

	public void insert(Cliente cliente);
	public Cliente find(Integer id);
	public void update(Cliente cliente);
	public Cliente findByCedula(String cedula);
}
