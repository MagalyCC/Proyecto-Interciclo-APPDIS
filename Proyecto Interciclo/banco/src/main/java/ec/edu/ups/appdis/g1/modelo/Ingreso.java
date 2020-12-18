package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingreso implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private int idIngreso;
	private Date fecha;
	private Cuenta cuenta;
	
	public int getIdIngreso() {
		return idIngreso;
	}
	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
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
	
	
}
