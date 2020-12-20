package ec.edu.ups.appdis.g1.vista;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.negocio.CajeroON;
import ec.edu.ups.appdis.g1.negocio.LoginON;

@Named
@RequestScoped
public class LoginBean {
	@Inject
	private LoginON lo;
	private String correo;
	private String password;
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doBuscar() {
		try {
			lo.buscarPersona(correo, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
