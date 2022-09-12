package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Vehiculo;

public interface IVehiculoRepository {

	public void insert(Vehiculo vehiculo);
	public Vehiculo find(Integer id);
	public void update(Vehiculo vehiculo);
	public List<Vehiculo> findVehiD(String marca, String modelo);
	public Vehiculo findVehiByPlaca(String placa);
}
