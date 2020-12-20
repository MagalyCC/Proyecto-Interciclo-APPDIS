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

	public List<Cuenta> buscarCuenta(String correo) {
		/*List<Persona> a = daoCuenta.getCuenta(correo);
		for (int i = 0; i < a.size(); i++) {
			try {
				String tipo = a.get(i).getUsuario().getCuenta().get(i).getTipo();
				System.out.println("esto");
				System.out.println(tipo);
			} catch (Exception ex) {

				System.out.println("Error buscar cuenta");
			}
			
		}*/
		return daoCuenta.getCuenta(correo).getUsuario().getCuenta();
		//int id=daoCuenta.getUsuario(correo);
		//return daoCuenta.getCuenta(id);
	}
}
