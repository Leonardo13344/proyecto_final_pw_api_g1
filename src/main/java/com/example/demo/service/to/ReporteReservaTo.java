package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ReporteReservaTo extends RepresentationModel<ReporteReservaTo> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer numReserva;//si
	private String cedulaCl;//si
	private String placaVehi;//si
	
	public Integer getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(Integer numReserva) {
		this.numReserva = numReserva;
	}
	
	public String getPlacaVehi() {
		return placaVehi;
	}
	public void setPlacaVehi(String placaVehi) {
		this.placaVehi = placaVehi;
	}
	public String getCedulaCl() {
		return cedulaCl;
	}
	public void setCedulaCl(String cedulaCl) {
		this.cedulaCl = cedulaCl;
	}
	
	
	

}
