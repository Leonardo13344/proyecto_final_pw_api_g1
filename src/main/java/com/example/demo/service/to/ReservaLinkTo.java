package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ReservaLinkTo extends RepresentationModel<ReservaLinkTo> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer numReserva;
	private String fechaI;
	private String fechaF;
	private String estado;
	private Double totalPagar;
	private String cedulaCl;
	private String nombreCl;
	private String placaVehi;
	private String modeloVehi;
	private String marcaVehi;
	public Integer getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(Integer numReserva) {
		this.numReserva = numReserva;
	}
	public String getFechaI() {
		return fechaI;
	}
	public void setFechaI(String fechaI) {
		this.fechaI = fechaI;
	}
	public String getFechaF() {
		return fechaF;
	}
	public void setFechaF(String fechaF) {
		this.fechaF = fechaF;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}
	public String getCedulaCl() {
		return cedulaCl;
	}
	public void setCedulaCl(String cedulaCl) {
		this.cedulaCl = cedulaCl;
	}
	public String getNombreCl() {
		return nombreCl;
	}
	public void setNombreCl(String nombreCl) {
		this.nombreCl = nombreCl;
	}
	public String getPlacaVehi() {
		return placaVehi;
	}
	public void setPlacaVehi(String placaVehi) {
		this.placaVehi = placaVehi;
	}
	public String getModeloVehi() {
		return modeloVehi;
	}
	public void setModeloVehi(String modeloVehi) {
		this.modeloVehi = modeloVehi;
	}
	public String getMarcaVehi() {
		return marcaVehi;
	}
	public void setMarcaVehi(String marcaVehi) {
		this.marcaVehi = marcaVehi;
	}
	
	
}
