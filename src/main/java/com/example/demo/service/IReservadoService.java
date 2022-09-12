package com.example.demo.service;

import com.example.demo.repository.model.Reservado;


public interface IReservadoService {

	public Integer insert(Reservado reservado, String cedula, String placa);
	public Integer find(Integer id);
}
