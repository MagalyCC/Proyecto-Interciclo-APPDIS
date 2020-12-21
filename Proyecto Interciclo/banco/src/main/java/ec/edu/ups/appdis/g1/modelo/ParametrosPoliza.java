package ec.edu.ups.appdis.g1.modelo;

/**
 * Importamos los administradores de entidad 
 *  la anotación @Persistence es utilizada en la clase 
 *  JPAclaseDao para inyectar automáticamente el EntityManager.
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * Anotacion @Entity 
 *esta anotación se debe de definir a 
 *nivel de clase y sirve únicamente para indicarle a JPA
 */
@Entity
public class ParametrosPoliza implements Serializable{
	private static final long serialVersionUID=1L;
	/**
	 * Anotación @Id
	 * puede ser cualquier tipo de datos soportado por JPA, 
	 * Anotación@GeneratedValue 
	 * con JPA es algo bastante habitual ya que existen muchas tablas 
	 * cuyas claves primarias preferimos que sean autoincrementales.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idParametro;
	private int diaMin;
	private int diaMax;
	private double monto;

	/**
	 * Generar Getters and Setters
	 * @return
	 */
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
