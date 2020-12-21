package ec.edu.ups.appdis.g1.vista;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
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
		String ventana = null;
		try {
			String rol = lo.buscarPersona(correo, password);
			if (rol.equals("Cliente")) {
				ventana = abrirVentana("ResumenCliente.xhtml");
			} else if (rol.equals("Secretario")) {
				ventana = abrirVentana("ResumenSecretario.xhtml");
			} else if (rol.equals("Administrador")) {
				ventana = abrirVentana("ResumenAdministrador.xhtml");
			} else if (rol.equals("Asistente")) {
				ventana = abrirVentana("ResumenAsistente.xhtml");
			} else {
				System.out.println("El rol no existe");
			}
			return ventana;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String abrirVentana(String nombre) {
		return nombre;
	}
}
