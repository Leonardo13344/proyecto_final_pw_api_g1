package com.example.demo.service;

import com.example.demo.repository.model.Transaccion;

public interface ITransaccionService {

	public void insert(Transaccion transaccion);
	public void update(Transaccion transaccion);
}
