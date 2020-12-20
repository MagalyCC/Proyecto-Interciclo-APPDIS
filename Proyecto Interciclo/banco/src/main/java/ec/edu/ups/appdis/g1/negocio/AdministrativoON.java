package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class AdministrativoON {
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private UsuarioDAO daoUsuario;

	CorreoON co = new CorreoON();

	public boolean registrarPersona(Usuario usuario, Persona persona) throws Exception {
		try {
			String correo = persona.getEmail();
			
			daoPersona.insert(persona);
			String password = co.contrasenaAleatoria();
			usuario.setPassword(password);
			usuario.setEstadoCuenta(1);
			usuario.setEstadoEliminado(0);
			usuario.setPersona(persona);
			daoUsuario.insert(usuario);
			co.sendAsHtml(correo, "Creacion de usuario", "Su contraseña es " + password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}
	
}
