package ec.edu.ups.appdis.g1.negocio;

import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.CuentaDAO;
import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;

public class ClienteON {
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private CuentaDAO daoCuenta;
	public List<Persona> buscarCuenta(String correo){
		return   daoCuenta.getCuenta(correo);
	}
}
