package ec.edu.ups.appdis.g1.negocio;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.CuentaDAO;
import ec.edu.ups.appdis.g1.DAO.IngresoDAO;
import ec.edu.ups.appdis.g1.DAO.ParametrosPolizaDAO;
import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.DAO.PolizaDAO;
import ec.edu.ups.appdis.g1.DAO.TransaccionDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Ingreso;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Poliza;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.Usuario;

public class ClienteON {
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private CuentaDAO daoCuenta;
	@Inject
	private PolizaDAO daoPoliza;
	@Inject
	private IngresoDAO daoIngreso;
	@Inject
	private TransaccionDAO daoTransaccion;
	@Inject
	private ParametrosPolizaDAO daoParametrosPoliza;

	public List<Cuenta> buscarCuenta(String correo) {
		return daoCuenta.getCuenta(correo).getUsuario().getCuenta();
	}
	public List<Cuenta> buscarPoliza(String correo) {
		return daoCuenta.getCuenta(correo).getUsuario().getCuenta();
	}
	public Cuenta readCuenta(int id) {
		try {
			return daoCuenta.read(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public Poliza readPoliza(int id) {
		try {
			return daoPoliza.read(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Transaccion> buscarTransacciones(int id) {
		return daoTransaccion.getTransacciones(id);
	}
	public List<Ingreso> buscarIngresos(String correo) {
		try {
			Usuario id = daoUsuario.getUsuarios(correo).getUsuario();
			List<Ingreso> ingre=daoIngreso.getIngresos(id.getIdUsuario());
			return ingre;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String Simulador(double monto, int plazo) {
		String interes="";
		List<ParametrosPoliza> list=daoParametrosPoliza.getPoliza(plazo);
		for (int i = 0; i < list.size(); i++) {
			double porcentaje=list.get(i).getMonto();
			double por=porcentaje/100;
			
		    System.out.println(list.get(i).getMonto());
		    double total=plazo*monto;
		    total=(total*por)/360;
		    System.out.println(total);
		    
		    BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
		    double val2 = bd.doubleValue();
		    interes=porcentaje+"-"+val2;
		    System.out.println(interes);
		}
		
		return interes;
	}
	
}
