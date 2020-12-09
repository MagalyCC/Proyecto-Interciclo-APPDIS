package ec.edu.ups.appdis.g1.modelo;

import java.util.Date;

import ec.edu.ups.appdis.g1.modelo.Cliente;
import ec.edu.ups.appdis.g1.modelo.Cuenta;


public class Deposito_Retiro {

	private int NumCuentaDR;
	private double valorRetiro;
	private double valorDeposito;
	private Date fecha;
	private Cuenta cuenta;
	private Cliente cliente;
	
	public int getNumCuentaDR() {
		return NumCuentaDR;
	}
	public void setNumCuentaDR(int numCuentaDR) {
		NumCuentaDR = numCuentaDR;
	}
	public double getValorRetiro() {
		return valorRetiro;
	}
	public void setValorRetiro(double valorRetiro) {
		this.valorRetiro = valorRetiro;
	}
	public double getValorDeposito() {
		return valorDeposito;
	}
	public void setValorDeposito(double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
