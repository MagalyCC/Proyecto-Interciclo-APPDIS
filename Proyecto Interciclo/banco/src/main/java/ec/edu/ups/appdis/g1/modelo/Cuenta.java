package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.edu.ups.appdis.g1.modelo.Persona;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuenta;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	private String tipo;
	private double saldo;
	@ManyToOne
	@JoinColumn
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
	private List<Poliza> poliza = new ArrayList<Poliza>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
	private List<Transferencia> transferencia = new ArrayList<Transferencia>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
	private List<Transaccion> transaccion = new ArrayList<Transaccion>();

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Poliza> getPoliza() {
		return poliza;
	}

	public void setPoliza(List<Poliza> poliza) {
		this.poliza = poliza;
	}

	public List<Transferencia> getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(List<Transferencia> transferencia) {
		this.transferencia = transferencia;
	}

	public List<Transaccion> getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(List<Transaccion> transaccion) {
		this.transaccion = transaccion;
	}

}
