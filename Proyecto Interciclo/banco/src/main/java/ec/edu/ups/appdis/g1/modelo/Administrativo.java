package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Administrativo implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private int idUsuario;
	private String rol;
	private String password;
	private int EstadoEliminado;
	private int EstadoCuenta;
	private Persona persona;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getEstadoEliminado() {
		return EstadoEliminado;
	}
	public void setEstadoEliminado(int estadoEliminado) {
		EstadoEliminado = estadoEliminado;
	}
	public int getEstadoCuenta() {
		return EstadoCuenta;
	}
	public void setEstadoCuenta(int estadoCuenta) {
		EstadoCuenta = estadoCuenta;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
