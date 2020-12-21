package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.IngresoDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Ingreso;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class LoginON {
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private IngresoDAO daoIngreso;
	CorreoON co = new CorreoON();
	Date date = new Date();
	
	public String buscarPersona(String correo, String password) throws Exception {
		Persona a = daoUsuario.getUsuarios(correo);
		Usuario id = daoUsuario.getUsuarios(correo).getUsuario();
		String password2 = a.getUsuario().getPassword();
		if(password2.equals(password)) {
			System.out.println("Bien");
			co.sendAsHtml(correo, "Ingreso cuenta bancaria", "Horade ingreso"+date);
			registrarIngreso(id);
			return a.getUsuario().getRol();
		}else {
			System.out.println("Mal");
			co.sendAsHtml(correo, "Intento de ingreso cuenta bancaria", "Horade de intento"+date);
		}
		return null;
		
	}
	public void registrarIngreso(Usuario id) {
		Ingreso ingreso=new Ingreso();
		ingreso.setFecha(date);
		ingreso.setUsuario(id);
		try {
			daoIngreso.insert(ingreso);
		} catch (Exception e) {
			System.out.println("Error ingresar registro");
			e.printStackTrace();
		}
		
	}
}
