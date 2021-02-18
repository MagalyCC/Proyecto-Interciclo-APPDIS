package ec.edu.ups.appdis.g1.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.appdis.g1.DAO.CuentaDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Poliza;
import ec.edu.ups.appdis.g1.modelo.Transferencia;
import ec.edu.ups.appdis.g1.negocio.CajeroON;
import ec.edu.ups.appdis.g1.negocio.ClienteON;
import ec.edu.ups.appdis.g1.negocio.LoginON;
import ec.edu.ups.appdis.g1.negocio.PolizaON;

@Path("mov")
public class Movil {
	@Inject
	private CajeroON co;
	@Inject
	private ClienteON clo;
	@Inject
	private CuentaDAO daoCuenta;
	@Inject
	private LoginON lo;
	@Inject
	private PolizaON po;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Path("login{correo}/{contrasena}")
	public String login(@PathParam("correo") String correo, @PathParam("contrasena") String contrasena) {
		try {
			String rol = lo.buscarPersona(correo, contrasena);
			if (rol.equals("Cliente")) {
				return "ok";
			} else {
				return rol;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al loguearse";
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Path("cambio")
	public void cambioContra(Persona p) {
		String correo = p.getEmail();
		co.cambio(correo);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Path("transferir")
	public void transferenciaServicio(Transferencia newTransferencia) {
		Cuenta c = newTransferencia.getCuentarecibe();
		try {
			if (daoCuenta.read(c.getIdCuenta()) == null) {
				newTransferencia.setCuentaTercero(newTransferencia.getCuentarecibe() + "");
				co.transferenciaTerceros(newTransferencia);
			} else {
				co.transferencia(newTransferencia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Path("resumen{correo}")
	public String resumen(@PathParam("correo") String correo) {
		String cadena = "";
		List<Cuenta> c = clo.buscarCuenta(correo);

		for (int i = 0; i < c.size(); i++) {
			int num = clo.buscarCuenta(correo).get(i).getIdCuenta();
			cadena = cadena + "Saldo en la cuenta: " + clo.readCuenta(num).getSaldo() + ";";

		}
		List<Poliza> p = po.polizaAprovada(correo);
		for (int i = 0; i < p.size(); i++) {
			int num = po.polizaAprovada(correo).get(i).getIdPoliza();
			cadena = cadena + "Estado de la poliza: " + clo.readPoliza(num).getEstado() + ";";
			cadena = cadena + "Fecha final poliza: " + clo.readPoliza(num).getFechaFin() + ";";
			cadena = cadena + "Monto poliza: " + clo.readPoliza(num).getMonto() + ";" + "\n";
		}
		/*
		 * cadena = cadena + clo.readPoliza(num).getEstado() + ";"; cadena = cadena +
		 * clo.readPoliza(num).getFechaFin() + ";"; cadena = cadena +
		 * clo.readPoliza(num).getMonto() + ";";
		 */

		return cadena;
	}
}