package ec.edu.ups.appdis.g1.vista;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;
import ec.edu.ups.appdis.g1.negocio.CajeroON;

@Named
@RequestScoped
public class CajeroBean {
	@Inject
	private CajeroON co;
	private Persona newPersona;
	private Usuario newUsuario;
	private Cuenta newCuenta;
	private ArrayList<Cuenta> list = null;

	public ArrayList<Cuenta> getList() {
		return list;
	}

	public void setList(ArrayList<Cuenta> list) {
		this.list = list;
	}

	public CajeroBean() {
		init();
	}

	public void init() {
		newPersona = new Persona();
		newUsuario = new Usuario();
		newCuenta = new Cuenta();
	}

	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}

	public Usuario getNewUsuario() {
		return newUsuario;
	}

	public void setNewUsuario(Usuario newUsuario) {
		this.newUsuario = newUsuario;
	}

	public Cuenta getNewCuenta() {
		return newCuenta;
	}

	public void setNewCuenta(Cuenta newCuenta) {
		this.newCuenta = newCuenta;
	}

	public String doGuardar() {
		try {
			co.crearCuenta(newUsuario, newPersona, newCuenta);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String doGuardarCuenta() {
		try {
			co.crearCuenta(newUsuario, newPersona, newCuenta);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String doBuscar() {
		try {
			Persona p = co.buscarPersona(newPersona.getCedula());
			newPersona.setNombre(p.getNombre());
			newPersona.setApellido(p.getApellido());
			newPersona.setEmail(p.getEmail());
			newPersona.setNumTelefono(p.getNumTelefono());
			list = (ArrayList<Cuenta>) co.buscarCuentas(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public void doTransaccion() {
		
	}
}
