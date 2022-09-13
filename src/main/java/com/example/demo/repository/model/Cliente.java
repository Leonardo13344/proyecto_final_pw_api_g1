package com.example.demo.repository.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "clie_id")
	private Integer id;
	
	@Column(name = "clie_cedula")
	private String cedula;
	
	@Column(name = "clie_nombre")
	private String nombre;
	
	@Column(name = "clie_apellido")
	private String apellido;
	
	@Column(name = "clie_fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name = "clie_genero")
	private String genero;
	
	@Column(name = "clie_registro")
	private String registro;//C (Cliente - el mismo se registró) y E (Un Empleado lo registró)
	
	@Column(name = "clie_numero_tarjeta")
	private String numeroTarjeta;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Reservado> vehichuloReservado;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Transaccion> transaccions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public List<Reservado> getVehichuloReservado() {
		return vehichuloReservado;
	}

	public void setVehichuloReservado(List<Reservado> vehichuloReservado) {
		this.vehichuloReservado = vehichuloReservado;
	}

	public List<Transaccion> getTransaccions() {
		return transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	
}
