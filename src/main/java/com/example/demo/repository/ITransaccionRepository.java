package com.example.demo.repository;



import com.example.demo.repository.model.Transaccion;

public interface ITransaccionRepository{
	
	public void insert(Transaccion transaccion);
	public void update(Transaccion transaccion);
	

}
