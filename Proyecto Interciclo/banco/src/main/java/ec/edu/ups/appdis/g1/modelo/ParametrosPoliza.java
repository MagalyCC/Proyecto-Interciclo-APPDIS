package ec.edu.ups.appdis.g1.modelo;

public class ParametrosPoliza {
	
	private int idParametro;
	private int diaMin;
	private int diaMax;
	private double monto;
	private Cuenta cuenta;
	
	public int getIdParametro() {
		return idParametro;
	}
	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}
	public int getDiaMin() {
		return diaMin;
	}
	public void setDiaMin(int diaMin) {
		this.diaMin = diaMin;
	}
	public int getDiaMax() {
		return diaMax;
	}
	public void setDiaMax(int diaMax) {
		this.diaMax = diaMax;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	

}
