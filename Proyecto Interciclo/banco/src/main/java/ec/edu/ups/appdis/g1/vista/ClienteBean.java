package ec.edu.ups.appdis.g1.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.Usuario;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;
import ec.edu.ups.appdis.g1.negocio.ClienteON;

/**
 * 
 * @Named Es un calificador basado en cadena (String) @Scope : Identifica
 *        anotaciones de alcance
 * @RequestScoped define el alcance en el que se almacenará el bean
 */
@Named
@RequestScoped
public class ClienteBean {
	@Inject
	private ClienteON co;
	private List<Cuenta> list = null;
	private List<Transaccion> listTransaccion = null;
	Date date = new Date();
	private String correo;
	private int IDCuenta;
	@Inject
	private LoginBean lo;

	public List<Transaccion> getListTransaccion() {
		if (list == null) {
			list = new ArrayList<Cuenta>();
			for (int i = 0; i < 6; i++) {
				Persona p = new Persona();
				Usuario u = new Usuario();
				Cuenta c = new Cuenta();
				c.setTipo("hola");
				list.add(c);
			}
		} else {
			
			//listTransaccion=co.buscarTransacciones(1);
		}
		return listTransaccion;
	}

	public void setListTransaccion(List<Transaccion> listTransaccion) {
		this.listTransaccion = listTransaccion;
	}

	public int getIDCuenta() {
		return IDCuenta;
	}

	public void setIDCuenta(int iDCuenta) {
		IDCuenta = iDCuenta;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Cuenta> getList() {
		if (list == null) {
			list = new ArrayList<Cuenta>();
			for (int i = 0; i < 6; i++) {
				Persona p = new Persona();
				Usuario u = new Usuario();
				Cuenta c = new Cuenta();
				c.setTipo("hola");
				list.add(c);
			}
		} else {
			String cor = lo.getCorreo();
			list = (List<Cuenta>) co.buscarCuenta(cor);
		}
		return list;
	}

	public void setList(List<Cuenta> list) {
		this.list = list;
	}

	public List<Transaccion> doDetalle() {
		setListTransaccion(listTransaccion=co.buscarTransacciones(IDCuenta));
		//System.out.println(IDCuenta);
		//listTransaccion=co.buscarTransacciones(IDCuenta);
		return listTransaccion;

	}
	public void buscarTransaccion() {
		
	}

}
