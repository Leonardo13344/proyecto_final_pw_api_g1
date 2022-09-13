package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.model.Reservado;
import com.example.demo.service.to.ReporteReservaTo;
import com.example.demo.service.to.ReservaTo;


public interface IReservadoService {

	public Integer insert(Reservado reservado, String cedula, String placa);
	public ReservaTo find(Integer id);
	public List<ReporteReservaTo> findAll(LocalDate fechaI, LocalDate fechaF);
}
