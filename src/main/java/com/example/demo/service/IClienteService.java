package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Cliente;
import com.example.demo.service.to.ClienteTo;
import com.example.demo.service.to.ClienteVipTo;

public interface IClienteService {

	public void insertC(Cliente cliente);
	public Cliente find(Integer id);
	public void update(Cliente cliente);
	public Cliente findByCedula(String cedula);
	public ClienteTo findByCedulaTo(String cedula);
	public void insertE(Cliente cliente);
	public List<ClienteVipTo> findAll();
}
