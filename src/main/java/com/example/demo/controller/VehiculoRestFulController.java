package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTo;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin("http://localhost:8080/")
public class VehiculoRestFulController {

	@Autowired
	private IVehiculoService vehiculoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehiculoTo> findVehiD(@RequestParam(value = "marca") String marca,
			@RequestParam(value = "modelo") String modelo) {
		List<VehiculoTo> aux = this.vehiculoService.findVehiD(marca, modelo);
		return aux;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> inserVehi(@RequestBody Vehiculo vehi) {
		try {
			this.vehiculoService.insert(vehi);
			return ResponseEntity.ok("Vehiculo insertado...");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error al insertar vehiculo...");
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{placa}")
	public ResponseEntity<Vehiculo> findByPlaca(@PathVariable("placa") String placa) {
		Vehiculo aux = this.vehiculoService.findVehiByPlaca(placa);
		return ResponseEntity.ok(aux);

	}

}
