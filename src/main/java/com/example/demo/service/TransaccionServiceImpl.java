package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ITransaccionRepository;
import com.example.demo.repository.model.Transaccion;

@Service
public class TransaccionServiceImpl implements ITransaccionService{

	@Autowired
	private ITransaccionRepository transaccionRepository;
	
	@Override
	public void insert(Transaccion transaccion) {
		// TODO Auto-generated method stub
		this.transaccionRepository.insert(transaccion);
	}

	@Override
	public void update(Transaccion transaccion) {
		// TODO Auto-generated method stub
		this.transaccionRepository.update(transaccion);
	}
	
	

}
