package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ClienteTo extends RepresentationModel<ClienteTo> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String fechaN;
	private String genero;
	private String registro;
	private String numeroT;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFechaN() {
		return fechaN;
	}
	public void setFechaN(String fechaN) {
		this.fechaN = fechaN;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getNumeroT() {
		return numeroT;
	}
	public void setNumeroT(String numeroT) {
		this.numeroT = numeroT;
	}
	
	
}
