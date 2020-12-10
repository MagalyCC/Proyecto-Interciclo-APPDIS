package ec.edu.ups.appdis.g1.modelo;

import java.util.Date;

public class TazaInteres {

	private Date fecha;
	private String Descripcion;
	private String TazasRefeciales;
	private double PorcentajeAnual;
	private String TazasMaximas;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getTazasRefeciales() {
		return TazasRefeciales;
	}
	public void setTazasRefeciales(String tazasRefeciales) {
		TazasRefeciales = tazasRefeciales;
	}
	public double getPorcentajeAnual() {
		return PorcentajeAnual;
	}
	public void setPorcentajeAnual(double porcentajeAnual) {
		PorcentajeAnual = porcentajeAnual;
	}
	public String getTazasMaximas() {
		return TazasMaximas;
	}
	public void setTazasMaximas(String tazasMaximas) {
		TazasMaximas = tazasMaximas;
	}
	
}
