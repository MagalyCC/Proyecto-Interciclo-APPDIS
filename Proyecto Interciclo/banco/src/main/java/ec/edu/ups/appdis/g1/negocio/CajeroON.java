package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class CajeroON {
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private UsuarioDAO daoUsuario;
	public boolean CrearCuenta (Usuario usuario) {
		
		return true;
	}
	
	public boolean registrarPersona(Usuario usuario) throws Exception {
		try {
			Persona persona=usuario.getPersona();
			daoUsuario.insert(usuario);
			daoPersona.insert(persona);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}
}
