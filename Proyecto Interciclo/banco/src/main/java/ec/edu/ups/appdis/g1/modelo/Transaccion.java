package ec.edu.ups.appdis.g1.modelo;

import java.util.Date;

import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Cuenta;


public class Transaccion {

	private int idCodigo;
	private double monto;
	private Cuenta cuenta;
	
	
	
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}

	
}
