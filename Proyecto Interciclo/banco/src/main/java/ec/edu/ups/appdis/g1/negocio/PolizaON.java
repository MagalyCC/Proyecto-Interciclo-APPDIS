package ec.edu.ups.appdis.g1.negocio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.CuentaDAO;
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
	private CuentaDAO daoCuenta;
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

	public List<Poliza> polizaAprovada(String correo) {
		List<Cuenta> numcu = daoCuenta.getCuenta(correo).getUsuario().getCuenta();
		int numcuenta = numcu.get(0).getIdCuenta();
		return daoPoliza.getPolizaAprovada(numcuenta);
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
		List<Cuenta> numcu = daoCuenta.getCuenta(correo).getUsuario().getCuenta();
		int numcuenta = numcu.get(0).getIdCuenta();
		c.setIdCuenta(numcuenta);
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

		cu.setIdCuenta(p.getCuenta().getIdCuenta());
		t.setCuentaenvia(cu);
		Cuenta cu2 = new Cuenta();
		cu2.setIdCuenta(1);
		t.setCuentarecibe(cu2);
		daoTransferencia.insert(t);

		matematicas(cu, cu2, p.getMonto());

	}

	public void matematicas(Cuenta cuenta1, Cuenta cuenta2, double monto) {
		try {
			Cuenta c = daoCuenta.read(cuenta1.getIdCuenta());
			c.setSaldo(c.getSaldo() - monto);
			daoCuenta.updateJPA(c);
			Cuenta c2 = daoCuenta.read(cuenta2.getIdCuenta());
			c2.setSaldo(c2.getSaldo() + monto);
			daoCuenta.updateJPA(c2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pagarPoliza() {
		try {
			
			List<Poliza> tam = daoPoliza.getPoliza();
			for (int i = 0; i < tam.size(); i++) {
				Poliza p = daoPoliza.read(i+1);
				Date dateFin = p.getFechaFin();
				if (dateFin == null) {
					System.out.println("Fecha nula");
				} else {
					System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
					System.out.println(dateFin+"         "+date);
					System.out.println(dateFin.after(date));
					if (dateFin.before(date)) {
						p.setFechaFin(null);
						daoPoliza.updateJPA(p);
						finPoliza(p);
					} else {
						System.out.println(dateFin+"Aun no se cumple la fecha"+date);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void finPoliza(Poliza p) {
		Transferencia t=new Transferencia();
		Cuenta c=new Cuenta();
		Cuenta c2=new Cuenta();
		try {
			t.setFecha(date);
			double a=(p.getInteres()/100)*p.getPlazo();
			double b=p.getMonto();
			double suma=a+b;
			t.setMonto(suma);
			c.setIdCuenta(1);
			t.setCuentaenvia(c);
			int numcu=p.getCuenta().getIdCuenta();
			c2.setIdCuenta(p.getCuenta().getIdCuenta());
			t.setCuentarecibe(c2);
			daoTransferencia.insert(t);
			Cuenta c3=daoCuenta.read(numcu);
			System.out.println("Saldooooooooooooooooooooooooooo c2"+c2.getSaldo());
			System.out.println("Saldooooooooooooooooooooooooooo c3"+c3.getSaldo());
			double saldo=c3.getSaldo();
			double suma2=suma+saldo;
			System.out.println("Saldooooooooooooooooooooooooooo suma"+suma);
			System.out.println("Suma2============="+suma2);
			c3.setSaldo(suma2);
			daoCuenta.updateJPA(c3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
