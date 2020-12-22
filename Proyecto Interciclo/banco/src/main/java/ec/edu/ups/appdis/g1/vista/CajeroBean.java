package ec.edu.ups.appdis.g1.vista;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.Usuario;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;
import ec.edu.ups.appdis.g1.negocio.CajeroON;
/**
 * 
 * @Named Es un calificador basado en cadena (String) @Scope : Identifica anotaciones de alcance
 * @RequestScoped define el alcance en el que se almacenará el bean
 */
@Named
@RequestScoped
public class CajeroBean {
	@Inject
	private CajeroON co;
	private Persona newPersona;
	private Usuario newUsuario;
	private Cuenta newCuenta;
	private Transaccion newTransaccion;
	private ArrayList<Cuenta> list = null;

	public Transaccion getNewTransaccion() {
		return newTransaccion;
	}

	public void setNewTransaccion(Transaccion newTransaccion) {
		this.newTransaccion = newTransaccion;
	}

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
		newTransaccion = new Transaccion();
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
			List<Persona> existe = co.existePersona(newPersona.getCedula());
			if (existe.size()==0) {
				co.crearCuenta(newUsuario, newPersona, newCuenta);
			} else {
				System.out.println("Solo crear cuenta");
				Persona p=co.buscarPersona(newPersona.getCedula());
				newCuenta.setUsuario(p.getUsuario());
				co.soloCuenta(newCuenta);
			}
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
			list = (ArrayList<Cuenta>) co.buscarCuentas(p.getUsuario().getIdUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void doTransaccion() {
		newTransaccion.setCuenta(newCuenta);
		co.transaccion(newTransaccion);
		co.actualizarCuenta(newCuenta, newTransaccion);
	}
}
