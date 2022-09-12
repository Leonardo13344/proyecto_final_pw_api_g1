package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.model.Cliente;
import com.example.demo.service.to.ClienteTo;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public void insertC(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.insertC(cliente);
	}
	
	@Override
	public void insertE(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.insertE(cliente);
	}

	@Override
	public Cliente find(Integer id) {
		// TODO Auto-generated method stub
		Cliente aux = this.find(id);
		return aux != null ? aux : null;
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.update(cliente);
	}

	@Override
	public Cliente findByCedula(String cedula) {
		// TODO Auto-generated method stub
		Cliente aux = this.clienteRepository.findByCedula(cedula);
		return aux;
	}

	@Override
	public ClienteTo findByCedulaTo(String cedula) {
		// TODO Auto-generated method stub
		Cliente aux = this.clienteRepository.findByCedula(cedula);
		return convertirClienteTo(aux);
	}
	
	
	private ClienteTo convertirClienteTo(Cliente cl) {
		ClienteTo aux = new ClienteTo();
		aux.setApellido(cl.getApellido());
		aux.setCedula(cl.getCedula());
		aux.setFechaN(cl.getFechaNacimiento().toString());
		aux.setGenero(cl.getGenero());
		aux.setNombre(cl.getNombre());
		aux.setNumeroT(cl.getNumeroTarjeta());
		aux.setRegistro(cl.getRegistro());
		return aux;
		
	}
	
	
	
}
