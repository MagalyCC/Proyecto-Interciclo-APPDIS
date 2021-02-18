package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.CuentaDAO;
import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.TransaccionDAO;
import ec.edu.ups.appdis.g1.DAO.TransferenciaDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.Transferencia;
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
	@Inject
	private TransferenciaDAO daoTransferencia;
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
	public void cambio(String correo) {
		Persona p=daoUsuario.getUsuarios(correo);
		String password = co.contrasenaAleatoria();
		Usuario u=p.getUsuario();
		try {
			
			u.setPassword(password);
			daoUsuario.update(u);
			co.sendAsHtml(correo, "Cambio de contraseña", "Su usuario es: " + correo + "Su nueva contraseña es: " + password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public boolean crearBanco() throws Exception {
		try {

			Persona p=new Persona();
			
			p.setNombre(null);
			p.setCedula("0000000000");
			daoPersona.insert(p);
			Usuario usuario=new Usuario();
			usuario.setPassword("");
			usuario.setEstadoCuenta(0);
			usuario.setEstadoEliminado(0);
			usuario.setPersona(p);
			usuario.setRol("Banco");
			daoUsuario.insert(usuario);
			Cuenta cuenta=new Cuenta();
			cuenta.setUsuario(usuario);
			
			cuenta.setFechaCreacion(date);
			cuenta.setSaldo(99999999);
			daoCuenta.insert(cuenta);
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
	public void transferencia(Transferencia entity) {
		try {
			entity.setFecha(date);
			daoTransferencia.insert(entity);
			actualizarCuentaSin(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void transferenciaTerceros(Transferencia entity) {
		try {
			entity.setFecha(date);
			entity.setCuentarecibe(null);
			daoTransferencia.insert(entity);
			resta(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void resta(Transferencia entity) {
		try {
			Cuenta c = daoCuenta.read(entity.getCuentaenvia().getIdCuenta());
			double saldo = c.getSaldo();
			c.setSaldo(saldo-entity.getMonto());
			daoCuenta.updateJPA(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void actualizarCuentaSin(Transferencia entity) {
		try {
			Cuenta c = daoCuenta.read(entity.getCuentaenvia().getIdCuenta());
			Cuenta c2 = daoCuenta.read(entity.getCuentarecibe().getIdCuenta());
			double saldo = c.getSaldo();
			if(c2==null) {
				c.setSaldo(saldo-entity.getMonto());
				daoCuenta.updateJPA(c);
			}else {
				c.setSaldo(saldo-entity.getMonto());
				daoCuenta.updateJPA(c);
				double saldo2 = c2.getSaldo();
				c2.setSaldo(saldo2+entity.getMonto());
				daoCuenta.updateJPA(c2);
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
