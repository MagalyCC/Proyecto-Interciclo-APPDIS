package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;
import java.util.Date;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.CuentaDAO;
import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class CajeroON {
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private CuentaDAO daoCuenta;
	CorreoON co = new CorreoON();
	Date date = new Date();
	public Persona buscarPersona(String cedula) throws Exception {
		try {
			return  daoPersona.read(cedula);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error buscar cedula");
		}
	}
	public boolean crearCuenta(Usuario usuario, Persona persona, Cuenta cuenta) throws Exception {
		try {
			
			String correo = persona.getEmail();
			
			daoPersona.insert(persona);
			String password = co.contrasenaAleatoria();
			usuario.setPassword(password);
			usuario.setEstadoCuenta(0);
			usuario.setEstadoEliminado(0);
			usuario.setPersona(persona);
			daoUsuario.insert(usuario);
			cuenta.setUsuario(usuario);
			cuenta.setFechaCreacion(date);
			cuenta.setSaldo(0);
			daoCuenta.insert(cuenta);
			
			co.sendAsHtml(correo, "Creacion de usuario", "Su contraseña es " + password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}
	public void agregarCuenta(Usuario usuario, Persona persona, Cuenta cuenta) throws Exception {
		String correo = persona.getEmail();
		cuenta.setUsuario(usuario);
		cuenta.setFechaCreacion(date);
		cuenta.setSaldo(0);
		daoCuenta.insert(cuenta);
		
		co.sendAsHtml(correo, "Nueva Cuenta", "Su nueva cuenta es de tipo " + cuenta.getTipo());
	}
}
