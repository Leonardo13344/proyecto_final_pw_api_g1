package com.example.demo.repository.model;

import java.time.LocalDate;

public class ReservaDTO {
	
	private LocalDate fechaI;
	private LocalDate fechaF;
	private String cedula;
	private String placa;
	
	public LocalDate getFechaI() {
		return fechaI;
	}
	public void setFechaI(LocalDate fechaI) {
		this.fechaI = fechaI;
	}
	public LocalDate getFechaF() {
		return fechaF;
	}
	public void setFechaF(LocalDate fechaF) {
		this.fechaF = fechaF;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	

}
