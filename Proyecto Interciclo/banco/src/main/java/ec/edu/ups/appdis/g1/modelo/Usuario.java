package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int idUsuario;
	private String rol;
	private String password;
	private int estadoEliminado;
	private int estadoCuenta;
	@OneToOne
	@JoinColumn
	private Persona persona;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Ingreso> ingreso=new ArrayList<Ingreso>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Cuenta> cuenta=new ArrayList<Cuenta>();
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEstadoEliminado() {
		return estadoEliminado;
	}
	public void setEstadoEliminado(int estadoEliminado) {
		this.estadoEliminado = estadoEliminado;
	}
	public int getEstadoCuenta() {
		return estadoCuenta;
	}
	public void setEstadoCuenta(int estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Ingreso> getIngreso() {
		return ingreso;
	}
	public void setIngreso(List<Ingreso> ingreso) {
		this.ingreso = ingreso;
	}
	
	
}
