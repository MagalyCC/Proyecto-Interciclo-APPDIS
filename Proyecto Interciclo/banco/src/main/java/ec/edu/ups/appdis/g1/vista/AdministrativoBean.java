package ec.edu.ups.appdis.g1.vista;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;

@Named
@RequestScoped
public class AdministrativoBean {
	@Inject
	private AdministrativoON ao;
	private Persona newPersona;
	
	public AdministrativoBean() {
		init();
	}

	public void init() {
		System.out.print("hola2");
		newPersona = new Persona();
	}

	public Persona getNewPersona() {
		System.out.print("hola23");
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		System.out.print("hola25");
		this.newPersona = newPersona;
	}

	public String doGuardar() {
		System.out.print("hola");
		System.out.print(newPersona);
		try {
			ao.registrarPersona(newPersona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
