package ec.edu.ups.appdis.g1.negocio;

import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.CuentaDAO;
import ec.edu.ups.appdis.g1.DAO.IngresoDAO;
import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.TransaccionDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Ingreso;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class ClienteON {
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private CuentaDAO daoCuenta;
	@Inject
	private IngresoDAO daoIngreso;
	@Inject
	private TransaccionDAO daoTransaccion;

	public List<Cuenta> buscarCuenta(String correo) {
		return daoCuenta.getCuenta(correo).getUsuario().getCuenta();
	}
	public List<Transaccion> buscarTransacciones(int id) {
		return daoTransaccion.getTransacciones(id);
	}
	public List<Ingreso> buscarIngresos(String correo) {
		try {
			Usuario id = daoUsuario.getUsuarios(correo).getUsuario();
			List<Ingreso> ingre=daoIngreso.getIngresos(id.getIdUsuario());
			return ingre;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
