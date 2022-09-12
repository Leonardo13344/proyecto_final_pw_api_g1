package com.example.demo.service;

import java.util.List;import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.model.Vehiculo;
import com.example.demo.service.to.VehiculoTo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Override
	public void insert(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		vehiculo.setEstado("D");
		this.vehiculoRepository.insert(vehiculo);
	}

	@Override
	public VehiculoTo find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VehiculoTo> findVehiD(String marca, String modelo) {
		// TODO Auto-generated method stub
		List<Vehiculo> aux = this.vehiculoRepository.findVehiD(marca, modelo);
		return aux.stream().map(v -> this.convertirVehiculoTo(v)).collect(Collectors.toList());
	}
	
	private VehiculoTo convertirVehiculoTo(Vehiculo vehiculo) {
		VehiculoTo aux = new VehiculoTo();
		aux.setPlaca(vehiculo.getPlaca());
		aux.setModelo(vehiculo.getModelo());
		aux.setMarca(vehiculo.getMarca());
		aux.setAnio(vehiculo.getAnio());
		aux.setEstado(vehiculo.getEstado());
		aux.setValorPorDia(vehiculo.getValorPorDia());
		return aux;
	}

	@Override
	public Vehiculo findVehiByPlaca(String placa) {
		// TODO Auto-generated method stub
		Vehiculo aux = this.vehiculoRepository.findVehiByPlaca(placa);
		return aux;
	}

	

}
