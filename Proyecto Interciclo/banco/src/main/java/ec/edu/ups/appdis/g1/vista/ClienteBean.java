package ec.edu.ups.appdis.g1.vista;

import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;
import ec.edu.ups.appdis.g1.negocio.ClienteON;

@Named
@RequestScoped
public class ClienteBean {
	@Inject
	private ClienteON co;
	private ArrayList<Persona> list=null;
	Date date=new Date();
	public ArrayList<Persona> getList() {
		if(list==null) {
			list= new ArrayList<Persona>();
			
			
			for(int i=0; i<6;i++) {
				/*Persona p=new Persona();
				p.setUsuario(usuario);
				Cuenta c=new Cuenta();
				c.setIdCuenta(i);
				c.setTipo("Tipo");
				c.setFechaCreacion(date);;
				c.setSaldo(0);
				list.add(c);*/
			}
		}else {
			list =(ArrayList<Persona>) co.buscarCuenta("aloja619@gmail.com");
		}
		return list;
	}
}
