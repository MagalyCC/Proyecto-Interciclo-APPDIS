package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParametrosPoliza implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idParametro;
	private int diaMin;
	private int diaMax;
	private double monto;

	
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

	

}
