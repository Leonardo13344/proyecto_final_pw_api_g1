package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IReservadoRepository;
import com.example.demo.repository.model.Cliente;
import com.example.demo.repository.model.Reservado;
import com.example.demo.repository.model.Transaccion;
import com.example.demo.repository.model.Vehiculo;
import com.example.demo.service.to.ReporteReservaTo;
import com.example.demo.service.to.ReservaLinkTo;
import com.example.demo.service.to.ReservaTo;


@Service
public class ReservadoServiceImpl implements IReservadoService{
	
	@Autowired
	private IReservadoRepository reservadoRepository;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private ITransaccionService transaccionService;

	@Override
	public Integer insert(Reservado reservado, String cedula, String placa) {
		// TODO Auto-generated method stub
		Vehiculo aux = this.existeYdisponible(placa);
		Cliente aux2 = this.existeCliente(cedula);
		if(aux != null && aux2 != null && !aux2.getNumeroTarjeta().isEmpty() && aux2.getNumeroTarjeta().length() > 2 && aux2.getNumeroTarjeta() != null) {
			reservado.setCedulaCliente(aux2.getCedula());
			reservado.setNombreCliente(aux2.getNombre());
			reservado.setCliente(aux2);
			reservado.setEstado("G");
			reservado.setVehiculo(aux);
			reservado.setPlacaVehi(aux.getPlaca());
			reservado.setMarcaVehi(aux.getMarca());
			reservado.setModeloVehi(aux.getModelo());
			Transaccion tran = fullTrans(aux, aux2, reservado);
			this.transaccionService.insert(tran);
			reservado.setTransaccion(tran);
			reservado.setTotalPagar(tran.getValorTotalAPagar().doubleValue());
			this.reservadoRepository.insert(reservado);
			Transaccion tran2 = new Transaccion();
			tran2 = tran;
			tran2.setReservado(reservado);
			this.transaccionService.update(tran2);
			return reservado.getId();
		}else {
			throw new RuntimeException();
		}
		
	}

	@Override
	public ReservaTo find(Integer id) {
		// TODO Auto-generated method stub
		Reservado aux = this.reservadoRepository.find(id);
		Reservado up = new Reservado();
		Vehiculo vehi = new Vehiculo();
		vehi = aux.getVehiculo();
		vehi.setEstado("ND");
		up = aux;
		up.setEstado("E");
		up.setVehiculo(vehi);
		this.reservadoRepository.update(up);
		return convertirReservaTo(up);
	}
	
	@Override
	public List<ReporteReservaTo> findAll(LocalDate fechaI, LocalDate fechaF) {
		// TODO Auto-generated method stub
		List<Reservado> aux = this.reservadoRepository.findAll(fechaI, fechaF);
		return aux.stream().map(r -> convertirReporteReservaTo(r)).collect(Collectors.toList());
	}
	
	@Override
	public ReservaLinkTo findDetallado(Integer id) {
		// TODO Auto-generated method stub
		Reservado aux = this.reservadoRepository.find(id);
		return convertirReservaLinkTo(aux);
	}
	
	@Override
	public void updateTarjeta(String numTarjeta, String cedula) {
		// TODO Auto-generated method stub
		Cliente cl = this.clienteService.findByCedula(cedula);
		cl.setNumeroTarjeta(numTarjeta);
		this.clienteService.update(cl);
	}
	
	private ReservaLinkTo convertirReservaLinkTo(Reservado re) {
		ReservaLinkTo aux = new ReservaLinkTo();
		aux.setCedulaCl(re.getCedulaCliente());
		aux.setEstado(re.getEstado());
		aux.setFechaF(re.getFechaFin().toString());
		aux.setFechaI(re.getFechaInicio().toString());
		aux.setMarcaVehi(re.getMarcaVehi());
		aux.setModeloVehi(re.getModeloVehi());
		aux.setNombreCl(re.getNombreCliente());
		aux.setNumReserva(re.getId());
		aux.setPlacaVehi(re.getPlacaVehi());
		aux.setTotalPagar(re.getTotalPagar());
		return aux;
	}
	
	private ReporteReservaTo convertirReporteReservaTo(Reservado re) {
		ReporteReservaTo aux = new ReporteReservaTo();
		aux.setCedulaCl(re.getCedulaCliente());
		aux.setNumReserva(re.getId());
		aux.setPlacaVehi(re.getPlacaVehi());
		return aux;
	}
	
	
	private Transaccion fullTrans(Vehiculo ve, Cliente cl, Reservado re) {
		long daysBetween = ChronoUnit.DAYS.between(re.getFechaInicio(), re.getFechaFin());
		System.out.println(daysBetween);
		Transaccion tran = new Transaccion();
		double valorIva = ve.getValorPorDia().doubleValue()*0.12;
		double subTotal = ve.getValorPorDia().doubleValue() * daysBetween;
		double totalPagar = subTotal + valorIva;
		tran.setValorTotalAPagar(new BigDecimal(totalPagar));
		tran.setValorSubTotal(new BigDecimal(subTotal));
		tran.setValorIva(new BigDecimal(valorIva));
		tran.setCliente(cl);
		tran.setCedulaCli(cl.getCedula());
		tran.setFechaCobro(LocalDate.now());
		tran.setNumeroTarjeta(cl.getNumeroTarjeta());
		tran.setNombreCli(cl.getNombre());
		return tran;
	}
	
	private ReservaTo convertirReservaTo(Reservado re) {
		ReservaTo aux = new ReservaTo();
		aux.setEstado(re.getEstado());
		aux.setFecha(re.getFechaInicio().toString() + "-" + re.getFechaFin().toString());
		aux.setModelo(re.getModeloVehi());
		aux.setPlaca(re.getPlacaVehi());
		aux.setReservadoPor(re.getCedulaCliente());
		return aux;
	}

	private Vehiculo existeYdisponible(String placa) {
		try {
			Vehiculo aux = this.vehiculoService.findVehiByPlaca(placa);
			if (aux == null) {
				throw new RuntimeException();
			} else if (aux.getEstado().equals("D")) {
				return aux;
			} else {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	private Cliente existeCliente(String cedula) {
		return this.clienteService.findByCedula(cedula);
	}

	

	

	

}
