package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.service.to.ClienteTo;
import com.example.demo.service.to.ClienteVipTo;

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
	public ResponseEntity<ClienteTo> findByCedula(@RequestParam(value = "cedula") String cedula) {
		try {
			ClienteTo aux = this.clienteService.findByCedulaTo(cedula);
			return ResponseEntity.ok(aux);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/vips")
	private List<ClienteVipTo> findAll(){
		return this.clienteService.findAll();
	}
	

}
