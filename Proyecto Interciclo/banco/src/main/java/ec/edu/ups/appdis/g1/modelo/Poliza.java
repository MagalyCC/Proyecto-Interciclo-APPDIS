package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Poliza implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private int idPoliza;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private double interes;
	private double monto;
	@ManyToOne
	@JoinColumn
	private Cuenta cuenta;
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdPoliza() {
		return idPoliza;
	}
	public void setIdPoliza(int idPoliza) {
		this.idPoliza = idPoliza;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
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
