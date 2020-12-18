package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;
import java.util.Date;

import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Cuenta;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaccion implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private int idTransaccion;
	private Date fecha;
	private String tipoTransaccion;
	private double monto;
	private Cuenta cuenta;
	
	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
	
}
