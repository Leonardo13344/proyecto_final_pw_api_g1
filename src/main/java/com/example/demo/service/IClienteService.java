package com.example.demo.service;

import com.example.demo.repository.model.Cliente;
import com.example.demo.service.to.ClienteTo;

public interface IClienteService {

	public void insertC(Cliente cliente);
	public Cliente find(Integer id);
	public void update(Cliente cliente);
	public Cliente findByCedula(String cedula);
	public ClienteTo findByCedulaTo(String cedula);
	public void insertE(Cliente cliente);
}
