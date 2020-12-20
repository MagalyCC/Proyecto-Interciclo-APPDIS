package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class LoginON {
	@Inject
	private UsuarioDAO daoUsuario;
	CorreoON co = new CorreoON();
	Date date = new Date();
	public void buscarPersona(String correo, String password) throws Exception {
		Persona a = daoUsuario.getUsuarios(correo);
		String password2 = a.getUsuario().getPassword();
		if(password2.equals(password)) {
			System.out.println("Bien");
			co.sendAsHtml(correo, "Ingreso cuenta bancaria", "Horade ingreso"+date);
		}else {
			System.out.println("Mal");
			co.sendAsHtml(correo, "Intento de ingreso cuenta bancaria", "Horade de intento"+date);
		}
		
	}
}
