package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class AdministrativoON {
	@Inject
	private PersonaDAO daoPersona;
	public boolean registrarPersona(Persona usuario) throws Exception {
		try {
			//Persona persona=usuario.getPersona();
			daoPersona.insert(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}
}
