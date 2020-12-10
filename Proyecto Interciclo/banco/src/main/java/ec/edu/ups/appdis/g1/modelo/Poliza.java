package ec.edu.ups.appdis.g1.modelo;

public class Poliza {

	private int NumPoliza;
	private int folio;
	private String tipoOperacionBancaria;
	private String MetodoPago;
	private double Saldo;
	private Cliente cliente;
	private Cuenta cuenta;
	
	
	public int getNumPoliza() {
		return NumPoliza;
	}
	public void setNumPoliza(int numPoliza) {
		NumPoliza = numPoliza;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getTipoOperacionBancaria() {
		return tipoOperacionBancaria;
	}
	public void setTipoOperacionBancaria(String tipoOperacionBancaria) {
		this.tipoOperacionBancaria = tipoOperacionBancaria;
	}
	public String getMetodoPago() {
		return MetodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		MetodoPago = metodoPago;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
