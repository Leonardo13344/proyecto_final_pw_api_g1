package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Transaccion;

public interface ITransaccionRepository{
	
	public void insert(Transaccion transaccion);
	public void update(Transaccion transaccion);
	

}
