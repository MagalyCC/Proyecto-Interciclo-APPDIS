package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;
import java.util.Date;
import ec.edu.ups.appdis.g1.modelo.Persona;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cuenta implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private int idCuenta;
	private Date fechaCreacion;
	private String tipo;
	private double saldo;
	private Administrativo usuario;
	
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Administrativo getUsuario() {
		return usuario;
	}
	public void setUsuario(Administrativo usuario) {
		this.usuario = usuario;
	}
	
	
}
