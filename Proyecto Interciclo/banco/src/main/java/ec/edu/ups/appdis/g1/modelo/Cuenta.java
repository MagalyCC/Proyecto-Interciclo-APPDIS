package ec.edu.ups.appdis.g1.modelo;

import java.util.Date;
import ec.edu.ups.appdis.g1.modelo.Persona;

public class Cuenta {

	private int idCodigo;
	private double monto;
	private Cuenta Cuenta;
	
	public int getIdCodigo() {
		return idCodigo;
	}
	public void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Cuenta getCuenta() {
		return Cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		Cuenta = cuenta;
	}
	
	
	
}
