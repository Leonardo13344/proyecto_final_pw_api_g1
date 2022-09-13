package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ClienteVipTo extends RepresentationModel<ClienteVipTo> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String cedula;
	private Double valorIva;
	private Double valorTotal;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String nombre) {
		this.cedula = nombre;
	}
	public Double getValorIva() {
		return valorIva;
	}
	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
