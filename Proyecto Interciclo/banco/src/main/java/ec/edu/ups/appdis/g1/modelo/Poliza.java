package ec.edu.ups.appdis.g1.modelo;

import java.util.Date;

public class Poliza {

	private int NumPoliza;
	private int folio;
	private Date fecha;
	private String tipoOperacionBancaria;
	private String MetodoPago;
	private double Saldo;
	private Persona cliente;
	private Cuenta cuenta;
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNumPoliza() {
		return NumPoliza;
	}
	public void setNumPoliza(int numPoliza) {
		NumPoliza = numPoliza;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getTipoOperacionBancaria() {
		return tipoOperacionBancaria;
	}
	public void setTipoOperacionBancaria(String tipoOperacionBancaria) {
		this.tipoOperacionBancaria = tipoOperacionBancaria;
	}
	public String getMetodoPago() {
		return MetodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		MetodoPago = metodoPago;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
