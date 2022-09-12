package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Cliente;

import com.example.demo.service.IClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("http://localhost:8080/")
public class ClienteRestFulController {

	@Autowired
	private IClienteService clienteService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertC(@RequestBody Cliente cliente) {
		try {
			this.clienteService.insertC(cliente);
			return ResponseEntity.ok("Cliente insertado correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cliente no insertado...");

		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/Empleado")
	public ResponseEntity<String> insertE(@RequestBody Cliente cliente) {
		try {
			this.clienteService.insertE(cliente);
			return ResponseEntity.ok("Cliente insertado correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cliente no insertado...");

		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> findByCedula(@RequestParam(value = "cedula") String cedula) {

		Cliente aux = this.clienteService.findByCedula(cedula);
		return ResponseEntity.ok(aux);

	}

}
