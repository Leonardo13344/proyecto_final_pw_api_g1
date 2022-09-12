package com.example.demo.repository.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos_reservados")
public class Reservado implements Serializable{

	/*
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "vere_id")
	private Integer id;
	
	@Column(name = "vere_fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name = "vere_fecha_fin")
	private LocalDate fechaFin;
	
	@Column(name = "vere_estado")
	private String estado;
	
	@OneToOne
	@JoinColumn(name = "vere_clie_id")
	private Cliente cliente;
	
	@Column(name = "vere_clie_cedula")
	private String cedulaCliente;
	
	@Column(name = "vere_clie_nombre")
	private String nombreCliente;
	
	@OneToOne
	@JoinColumn(name = "vere_vehi_id")
	private Vehiculo vehiculo;
	
	@Column(name = "vere_vehi_placa")
	private String placaVehi;
	
	@Column(name = "vere_vehi_modelo")
	private String modeloVehi;
	
	@Column(name = "vere_vehi_marca")
	private String marcaVehi;
	
	@OneToOne(mappedBy = "reservado")
	private Transaccion transaccion;
	
	@Column(name = "vere_tran_total")
	private Double totalPagar;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public String getPlacaVehi() {
		return placaVehi;
	}

	public void setPlacaVehi(String placaVehi) {
		this.placaVehi = placaVehi;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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

	public Double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}
	
	
	
	

}
