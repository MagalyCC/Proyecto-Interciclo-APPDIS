package ec.edu.ups.appdis.g1.vista;

import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.DAO.PersonaDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Ingreso;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Poliza;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.Usuario;
import ec.edu.ups.appdis.g1.negocio.AdministrativoON;
import ec.edu.ups.appdis.g1.negocio.ClienteON;
import ec.edu.ups.appdis.g1.negocio.PolizaON;

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
	@Inject
	private PersonaDAO dao;
	private List<Cuenta> list = null;
	private List<Transaccion> listTransaccion = null;
	private List<Ingreso> listIngreso = null;
	private List<Poliza> listPoliza = null;
	Date date = new Date();
	private String correo;
	private int IDCuenta;
	@Inject
	private LoginBean lo;
	@Inject
	private PolizaON po;
	private double monto;
	private int plazo;
	private String mensaje;
	private String mensaje2;
	static String cor;

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
		}
		return listTransaccion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje2() {
		return mensaje2;
	}

	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
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

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
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
			cor = lo.getCorreo();
			list = (List<Cuenta>) co.buscarCuenta(cor);
		}
		return list;
	}

	public void setList(List<Cuenta> list) {
		this.list = list;
	}

	public List<Transaccion> doDetalle() {
		setListTransaccion(listTransaccion = co.buscarTransacciones(IDCuenta));
		return listTransaccion;

	}

	public List<Ingreso> listarAccesos() {
		listIngreso = co.buscarIngresos(cor);
		return listIngreso;
	}
	

	
	
	

	
	

	public List<Poliza> getListPoliza() {
		if ((ArrayList<Poliza>) po.polizaAprovada(cor) == null) {
			listPoliza = new ArrayList<Poliza>();
			for (int i = 0; i < 6; i++) {
				Poliza p = new Poliza();
				p.setCuenta(null);
				p.setEstado(null);
				p.setFecha(null);
				listPoliza.add(p);
			}
		} else {
			listPoliza = (ArrayList<Poliza>) po.polizaAprovada(cor);
		}
		return listPoliza;
	}

	public void setListPoliza(List<Poliza> listPoliza) {
		this.listPoliza = listPoliza;
	}

	public void doSimular() {
		String string = co.Simulador(monto, plazo);
		String[] parts = string.split("-");
		mensaje = parts[0];
		mensaje2 = parts[1];
	}
	
	public void doPoliza() throws Exception {
		correo="aloja619";
		po.SolicitarPoliza(cor, monto, plazo);		
	}
	
	
	
	
	
	
	/*private InputStream arCedula;
	private InputStream arPlanillaServicios;
	public void archivo1(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		arCedula = event.getFile().getInputStream();
	}
	*//*
	public void archivo2(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		arPlanillaServicios = event.getFile().getInputStream();
	}*/
	/*public void doCargar() throws FileNotFoundException, SQLException {
		dao.guardaArchivo("C:/Users/aloja/Desktop/R.pdf");
	}*/
}
