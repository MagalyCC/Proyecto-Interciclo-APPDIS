package ec.edu.ups.appdis.g1.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;
import ec.edu.ups.appdis.g1.negocio.ClienteON;

@Named
@RequestScoped
public class ClienteBean {
	@Inject
	private ClienteON co;
	private List<Cuenta> list=null;
	Date date=new Date();
	
	public List<Cuenta> getList() {
		if(list==null) {
			list= new ArrayList<Cuenta>();
			for(int i=0; i<6;i++) {
				Persona p=new Persona();
				Usuario u=new Usuario();
				Cuenta c=new Cuenta();
					c.setTipo("hola");
				list.add(c);
			}
		}else {
			list =  (List<Cuenta>) co.buscarCuenta("aloja619@gmail.com");
			System.out.println(list.size());
			System.out.println(list.get(0).getTipo());
		}
		return list;
	}

	public void setList(List<Cuenta> list) {
		this.list = list;
	}
	
}
