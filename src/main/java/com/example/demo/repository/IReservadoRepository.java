package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.model.Reservado;

public interface IReservadoRepository {

	public void insert(Reservado reservado);
	public Reservado find(Integer id);
	public List<Reservado> findAll(LocalDate fechaI, LocalDate fechaF);
}
