package ec.edu.ups.appdis.g1.negocio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.ParametrosPolizaDAO;
import ec.edu.ups.appdis.g1.DAO.PolizaDAO;
import ec.edu.ups.appdis.g1.DAO.TransferenciaDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Poliza;
import ec.edu.ups.appdis.g1.modelo.Transferencia;

public class PolizaON {
	@Inject
	private ParametrosPolizaDAO daoParametros;
	@Inject
	private PolizaDAO daoPoliza;
	@Inject
	private TransferenciaDAO daoTransferencia;
	Date date = new Date();

	public ParametrosPoliza buscarParametros(int idPoliza) throws Exception {

		try {
			return daoParametros.read(idPoliza);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
	}

	public List<ParametrosPoliza> buscarParametrosLista() {
		return daoParametros.getParametros();
	}

	public List<Poliza> buscarPoliza() {
		return daoPoliza.getPoliza();
	}

	public void SolicitarPoliza(String correo, double monto, int plazo) throws Exception {
		Poliza p = new Poliza();
		Cuenta c = new Cuenta();
		p.setEstado("En espera");
		double porcentaje;
		List<ParametrosPoliza> list = daoParametros.getPoliza(plazo);
		for (int i = 0; i < list.size(); i++) {
			porcentaje = list.get(i).getMonto();
			System.out.println(porcentaje);
			p.setInteres(porcentaje);
		}
		p.setPlazo(plazo);
		p.setMonto(monto);
		c.setIdCuenta(1);
		p.setCuenta(c);
		daoPoliza.insert(p);
		/*
		 * Date dt = date; System.out.println("Today:    "+dt); Calendar c =
		 * Calendar.getInstance(); c.setTime(dt); c.add(Calendar.DATE, plazo); dt =
		 * c.getTime(); System.out.println("Tomorrow: "+dt);
		 */
	}

	public void aceptarPoli(int idPoliza) throws Exception {
		Poliza p = daoPoliza.read(idPoliza);
		Cuenta cu = new Cuenta();
		Transferencia t = new Transferencia();
		int plazo = p.getPlazo();
		p.setFecha(date);
		Date dt = date;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, plazo);
		dt = c.getTime();
		p.setFechaFin(dt);
		p.setEstado("Aprobado");
		daoPoliza.updateJPA(p);
		t.setFecha(date);
		t.setMonto(p.getMonto());
		cu.setIdCuenta(1);
		t.setCuentaenvia(cu);

		cu.setIdCuenta(0);
		t.setCuentarecibe(cu);
		daoTransferencia.insert(t);

	}
}
