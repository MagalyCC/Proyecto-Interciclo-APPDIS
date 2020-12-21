package ec.edu.ups.appdis.g1.vista;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;
import ec.edu.ups.appdis.g1.negocio.PolizaON;
/**
 * 
 * @Named Es un calificador basado en cadena (String) @Scope : Identifica anotaciones de alcance
 * @RequestScoped define el alcance en el que se almacenará el bean
 */
@Named
@RequestScoped
public class AdministrativoBean {
	/**
	 * @Inject identifica un punto el cual una dependencia en una clase o interfaz Java puede ser inyectada en una clase destino
	 */
	// @EJB
	@Inject
	private AdministrativoON ao;
	@Inject
	private PolizaON po;
	private Persona newPersona;
	private Usuario newUsuario;
	private ArrayList<ParametrosPoliza> list = null;
	private ParametrosPoliza newPoliza;

	public ParametrosPoliza getNewPoliza() {
		return newPoliza;
	}

	public void setNewPoliza(ParametrosPoliza newPoliza) {
		this.newPoliza = newPoliza;
	}

	/**
	 * Metodo Lista
	 * @return
	 */
	public ArrayList<ParametrosPoliza> getList() {
		if (list == null) {
			list = new ArrayList<ParametrosPoliza>();
			for (int i = 0; i < 6; i++) {
				ParametrosPoliza p = new ParametrosPoliza();
				p.setDiaMax(i + 30);
				p.setDiaMin(i + 60);
				p.setMonto(i);
				list.add(p);
			}
		} else {
			list = (ArrayList<ParametrosPoliza>) po.buscarParametrosLista();
		}
		return list;
	}

	public void setList(ArrayList<ParametrosPoliza> list) {
		this.list = list;
	}

	public AdministrativoBean() {
		init();
	}

	public void init() {
		newPersona = new Persona();
		newUsuario = new Usuario();
		newPoliza = new ParametrosPoliza();
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

	/**
	 * Metodo Guardar Datos
	 * @return
	 */
	public String doGuardar() {
		try {
			ao.registrarPersona(newUsuario, newPersona);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
/**
 * Metodo Borrar Datos
 * @return
 */
	public String doBorrar() {
		try {
			ao.BorrarParametroz(newPoliza.getIdParametro());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
/**
 * Metodo Buscar Datos
 * @return
 */
	public String doBuscar() {
		try {
			ParametrosPoliza pp = ao.BuscarParametros(newPoliza.getIdParametro());
			newPoliza.setDiaMin(pp.getDiaMin());
			newPoliza.setDiaMax(pp.getDiaMax());
			newPoliza.setMonto(pp.getMonto());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
/**
 * Metodo Actualizar Datos
 * @return
 */
	public String doActualizar() {
		try {
			ao.ActualizaParametros(newPoliza);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * Metodo guardar parametros 
	 * @return
	 */
	public String doGuardarParametros() {
		try {
			newPoliza.setIdParametro(0);
			ao.CrearParametros(newPoliza);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
