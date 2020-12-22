package ec.edu.ups.appdis.g1.vista;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.negocio.CajeroON;
import ec.edu.ups.appdis.g1.negocio.LoginON;
/**
 * 
 * @Named Es un calificador basado en cadena (String) @Scope : Identifica anotaciones de alcance
 * @RequestScoped define el alcance en el que se almacenará el bean
 */
@Named
@RequestScoped
public class LoginBean {
	@Inject
	private LoginON lo;
	private String correo;
	private String password;
	private int cont = 0;

	public LoginBean() {
		init();
	}

	public void init() {
		correo=new String();
	}

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

	public String retornaCorreo() {
		return correo;

	}

	public String doBuscar() {

		String ventana = null;
		try {

			String rol = lo.buscarPersona(correo, password);
			if (rol.equals(null)) {
				cont++;
				System.out.println(cont);

			} else {
				if (rol.equals("Cliente")) {
					ventana = abrirVentana("ResumenCliente.xhtml");
					ClienteBean cb = new ClienteBean();
					cb.setCorreo(correo);
				} else if (rol.equals("Secretario")) {
					ventana = abrirVentana("ResumenSecretario.xhtml");
				} else if (rol.equals("Administrador")) {
					ventana = abrirVentana("ResumenAdministrador.xhtml");
				} else if (rol.equals("Asistente")) {
					ventana = abrirVentana("ResumenAsistente.xhtml");
				} else {
					cont++;
					System.out.println(cont);
					System.out.println("El rol no existe");
				}
			}
			return ventana;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}

	public String abrirVentana(String nombre) {
		return nombre;
	}
}
