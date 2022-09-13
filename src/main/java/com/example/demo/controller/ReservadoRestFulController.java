package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.ReservaDTO;
import com.example.demo.repository.model.Reservado;
import com.example.demo.service.IReservadoService;
import com.example.demo.service.to.ReporteReservaTo;
import com.example.demo.service.to.ReservaTo;


@RestController
@RequestMapping("/reservaciones")
@CrossOrigin("http://localhost:8080/")
public class ReservadoRestFulController {

	@Autowired
	private IReservadoService reservadoService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Integer> insertReservado(@RequestBody ReservaDTO reservado) {
		Reservado re = new Reservado();
		re.setFechaInicio(reservado.getFechaI());
		re.setFechaFin(reservado.getFechaF());
		Integer aux = this.reservadoService.insert(re, reservado.getCedula(), reservado.getPlaca());
		return ResponseEntity.ok(aux);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="{numReserva}")
	public ResponseEntity<ReservaTo> retirarVehiReservado(@PathVariable("numReserva") Integer id){
		ReservaTo re = this.reservadoService.find(id);
		return ResponseEntity.ok(re);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReporteReservaTo> findAll(@RequestParam(value="fechaI") String fechaI, @RequestParam(value="fechaF") String fechaF){
		LocalDate aux = LocalDate.parse(fechaI);
		LocalDate aux2 = LocalDate.parse(fechaF);
		return this.reservadoService.findAll(aux, aux2);
	}

}
