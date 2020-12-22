package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.ParametrosPolizaDAO;
import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class AdministrativoON {
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private ParametrosPolizaDAO daoParametro;

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
			co.sendAsHtml(correo, "Creacion de usuario", "Su usuario es: " + correo + "Su contraseña es: " + password
					+ "Su cuenta es de tipo: " + usuario.getRol());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}

	public void BorrarParametroz(int id) {
		try {
			daoParametro.deleteId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ParametrosPoliza BuscarParametros(int id) {
		try {
			return daoParametro.read(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void ActualizaParametros(ParametrosPoliza parametro) {
		try {
			daoParametro.updateJPA(parametro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CrearParametros(ParametrosPoliza parametro) {
		try {
			daoParametro.insertJPA(parametro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Usuario> buscarPersonaLista() {
		return daoUsuario.listaPersonas();
	}

	public void BorrarUsuario(String cedula) {
		try {
			daoPersona.deleteId(cedula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
