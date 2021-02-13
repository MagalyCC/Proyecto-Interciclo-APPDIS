package ec.edu.ups.appdis.g1.vista;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Poliza;
import ec.edu.ups.appdis.g1.negocio.PolizaON;
@Named
@RequestScoped
public class AsistenteBean {
	@Inject
	private PolizaON po;
	private int idPoliza;
	private ArrayList<Poliza> list = null;
	public ArrayList<Poliza> getList() {
		if (list == null) {
			list = new ArrayList<Poliza>();
			for (int i = 0; i < 6; i++) {
				Poliza p = new Poliza();
				p.setCuenta(null);
				p.setEstado(null);
				p.setFecha(null);
				list.add(p);
			}
		} else {
			list = (ArrayList<Poliza>) po.buscarPoliza();
		}
		return list;
	}
	public void setList(ArrayList<Poliza> list) {
		this.list = list;
	}
	public int getIdPoliza() {
		return idPoliza;
	}
	public void setIdPoliza(int idPoliza) {
		this.idPoliza = idPoliza;
	}
	public void aceptarPoliza() throws Exception {
		po.aceptarPoli(idPoliza);
	}
}
