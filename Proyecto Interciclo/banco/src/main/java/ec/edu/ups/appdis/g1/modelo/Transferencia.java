package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transferencia implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private int idCodigo;
	private double monto;
	private Cuenta cuenta;
	
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
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
	
}
