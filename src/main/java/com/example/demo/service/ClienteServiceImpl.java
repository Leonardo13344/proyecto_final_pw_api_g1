package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.model.Cliente;
import com.example.demo.repository.model.Transaccion;
import com.example.demo.service.to.ClienteTo;
import com.example.demo.service.to.ClienteVipTo;

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
		if(aux != null) {
			return convertirClienteTo(aux);
		}else {
			throw new RuntimeException();
		}
		
	}
	
	@Override
	public List<ClienteVipTo> findAll() {
		// TODO Auto-generated method stub
		List<Cliente> aux = this.clienteRepository.findAll();
		List<ClienteVipTo> aux2 = aux.stream().map(cl -> convertirClienteVipTo(cl)).collect(Collectors.toList());
		return aux2.stream().sorted((x,y) -> y.getValorTotal().compareTo(x.getValorTotal())).collect(Collectors.toList());
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
	
	private ClienteVipTo convertirClienteVipTo(Cliente cl) {
		ClienteVipTo aux = new ClienteVipTo();
		aux.setCedula(cl.getCedula());
		Double sumTotal = (double) 0;
		Double sumIva = (double) 0;
		for (Transaccion t : cl.getTransaccions()) {
			sumTotal =+ t.getValorTotalAPagar().doubleValue();
			sumIva =+ t.getValorIva().doubleValue();
		}
		aux.setValorTotal(sumTotal);
		aux.setValorIva(sumIva);
		return aux;
	}

	
	
	
}
