package com.example.demo.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transacciones")
public class Transaccion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "tran_id")
	private Integer id;
	
	@Column(name = "tran_numero_tarjeta")
	private String numeroTarjeta;
	
	@Column(name = "tran_valor_sub_total")
	private BigDecimal valorSubTotal;
	
	@Column(name = "tran_valor_iva")
	private BigDecimal valorIva;
	
	@Column(name = "tran_valor_total_a_pagar")
	private BigDecimal valorTotalAPagar;
	
	@Column(name = "tran_fecha_cobro")
	private LocalDate fechaCobro;
	
	@ManyToOne
	@JoinColumn(name = "tran_clie_id")
	private Cliente cliente;
	
	@Column(name = "tran_clie_cedula")
	private String cedulaCli;
	
	@Column(name = "tran_clie_nombre")
	private String nombreCli;
	
	@OneToOne
	@JoinColumn(name = "tran_vere_id")
	private Reservado reservado;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorSubTotal() {
		return valorSubTotal;
	}

	public void setValorSubTotal(BigDecimal valorSubTotal) {
		this.valorSubTotal = valorSubTotal;
	}

	public BigDecimal getValorIva() {
		return valorIva;
	}

	public void setValorIva(BigDecimal valorIva) {
		this.valorIva = valorIva;
	}

	public BigDecimal getValorTotalAPagar() {
		return valorTotalAPagar;
	}

	public void setValorTotalAPagar(BigDecimal valorTotalAPagar) {
		this.valorTotalAPagar = valorTotalAPagar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(LocalDate fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public String getCedulaCli() {
		return cedulaCli;
	}

	public void setCedulaCli(String cedulaCli) {
		this.cedulaCli = cedulaCli;
	}

	public String getNombreCli() {
		return nombreCli;
	}

	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	public Reservado getReservado() {
		return reservado;
	}

	public void setReservado(Reservado reservado) {
		this.reservado = reservado;
	}
	
	
	
}
