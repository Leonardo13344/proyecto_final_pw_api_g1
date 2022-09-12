package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTo;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin("http://localhost:8080/")
public class VehiculoRestFulController {
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehiculoTo> findVehiD(@RequestParam(value="marca") String marca, @RequestParam(value="modelo") String modelo){
		List<VehiculoTo> aux = this.vehiculoService.findVehiD(marca, modelo);
		return aux;
	}
	
	

}
