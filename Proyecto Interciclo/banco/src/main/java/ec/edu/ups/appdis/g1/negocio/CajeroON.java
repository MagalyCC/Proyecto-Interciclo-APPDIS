package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.CuentaDAO;
import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.TransaccionDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class CajeroON {
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private CuentaDAO daoCuenta;
	@Inject
	private TransaccionDAO daoTransaccion;
	CorreoON co = new CorreoON();
	Date date = new Date();

	public Persona buscarPersona(String cedula) throws Exception {
		try {
			return daoPersona.read(cedula);
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
			usuario.setRol("Cliente");
			daoUsuario.insert(usuario);
			cuenta.setUsuario(usuario);
			cuenta.setFechaCreacion(date);
			cuenta.setSaldo(0);
			daoCuenta.insert(cuenta);

			co.sendAsHtml(correo, "Creacion de usuario", "Su usuario es: " + correo + "Su contraseña es: " + password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}

	public List<Cuenta> buscarCuentas(int id) {
		return daoCuenta.getIdCuentas(id);
	}

	public void transaccion(Transaccion entity) {
		try {
			entity.setFecha(date);
			daoTransaccion.insert(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizarCuenta(Cuenta cuenta, Transaccion transaccion) {
		try {
			Cuenta c = daoCuenta.read(cuenta.getIdCuenta());
			cuenta.setFechaCreacion(c.getFechaCreacion());
			cuenta.setTipo(c.getTipo());
			cuenta.setUsuario(c.getUsuario());
			double saldo = c.getSaldo();
			if (transaccion.getTipoTransaccion().equals("Retiro")) {
				cuenta.setSaldo(saldo - transaccion.getMonto());
				daoCuenta.updateJPA(cuenta);
			} else if (transaccion.getTipoTransaccion().equals("Deposito")) {
				cuenta.setSaldo(saldo + transaccion.getMonto());
				daoCuenta.updateJPA(cuenta);
			} else {
				System.out.println("mal muy mal");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Persona> existePersona(String cedula){
		return daoPersona.existePersona(cedula);
	}
	public void soloCuenta(Cuenta cuenta) {
		try {
			cuenta.setFechaCreacion(date);
			daoCuenta.insert(cuenta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
