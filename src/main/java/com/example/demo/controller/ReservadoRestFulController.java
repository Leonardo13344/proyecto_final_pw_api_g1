package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.ReservaDTO;
import com.example.demo.repository.model.Reservado;
import com.example.demo.service.IReservadoService;


@RestController
@RequestMapping("/reservaciones")
@CrossOrigin("http://localhost:8080/")
public class ReservadoRestFulController {

	@Autowired
	private IReservadoService reservadoService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Integer> insertReservado(@RequestBody ReservaDTO reservado) {
		/*try {
			Integer aux = this.reservadoService.insert(reservado, cedula, placa);
			return ResponseEntity.ok(aux);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);
		}*/
		Reservado re = new Reservado();
		re.setFechaInicio(reservado.getFechaI());
		re.setFechaFin(reservado.getFechaF());
		Integer aux = this.reservadoService.insert(re, reservado.getCedula(), reservado.getPlaca());
		return ResponseEntity.ok(aux);

	}

}
