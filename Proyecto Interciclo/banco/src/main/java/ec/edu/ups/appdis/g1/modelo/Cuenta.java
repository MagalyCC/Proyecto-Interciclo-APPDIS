package ec.edu.ups.appdis.g1.modelo;

import java.util.Date;
import ec.edu.ups.appdis.g1.modelo.Persona;

public class Cuenta {

	private int Numerocuenta;
	private Date Fecha;
	private double saldo;
	private String TipoCuenta;
	private boolean EstadoCuenta;
	private Persona cliente;
	
	public int getNumerocuenta() {
		return Numerocuenta;
	}
	public void setNumerocuenta(int numerocuenta) {
		Numerocuenta = numerocuenta;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipoCuenta() {
		return TipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}
	public boolean isEstadoCuenta() {
		return EstadoCuenta;
	}
	public void setEstadoCuenta(boolean estadoCuenta) {
		EstadoCuenta = estadoCuenta;
	}
	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	
	
}
