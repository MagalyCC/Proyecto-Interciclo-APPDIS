package ec.edu.ups.appdis.g1.vista;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
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
			co.crearCuenta(newUsuario,newPersona,newCuenta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public String doGuardarCuenta() {
		try {
			co.crearCuenta(newUsuario,newPersona,newCuenta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public String doBuscar() {
		try {
			Persona p=co.buscarPersona(newPersona.getCedula());
			if(p.getNombre().length()==0) {
				System.out.print("No existe");
			}else {
				System.out.print("Existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
