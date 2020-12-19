package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private String cedula;
	private String nombre;
	private String email;
	private String numTelefono;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", email=" + email + ", numTelefono=" + numTelefono
				+ "]";
	}
	
	
}
