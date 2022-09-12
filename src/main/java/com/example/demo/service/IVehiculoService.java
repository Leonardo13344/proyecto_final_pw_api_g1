package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Vehiculo;
import com.example.demo.service.to.VehiculoTo;

public interface IVehiculoService {
	
	public void insert(Vehiculo vehiculo);
	public VehiculoTo find(Integer id);
	public void update(Vehiculo vehiculo);
	public List<VehiculoTo> findVehiD(String marca, String modelo);
	public Vehiculo findVehiByPlaca(String placa);

}
