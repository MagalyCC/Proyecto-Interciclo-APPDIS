package ec.edu.ups.appdis.g1.vista;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;
import ec.edu.ups.appdis.g1.negocio.PolizaON;

@Named
@RequestScoped
public class AdministrativoBean {
	@Inject
	private AdministrativoON ao;
	@Inject
	private PolizaON po;
	private Persona newPersona;
	private Usuario newUsuario;
	private ArrayList<ParametrosPoliza> list=null;
	
	public ArrayList<ParametrosPoliza> getList() {
		if(list==null) {
			list= new ArrayList<ParametrosPoliza>();
			for(int i=0; i<6;i++) {
				ParametrosPoliza p=new ParametrosPoliza();
				p.setDiaMax(i+30);
				p.setDiaMin(i+60);
				p.setMonto(i);
				list.add(p);
			}
		}else {
			list =(ArrayList<ParametrosPoliza>) po.buscarParametrosLista();
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

	public String doGuardar() {
		try {
			ao.registrarPersona(newUsuario,newPersona);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
