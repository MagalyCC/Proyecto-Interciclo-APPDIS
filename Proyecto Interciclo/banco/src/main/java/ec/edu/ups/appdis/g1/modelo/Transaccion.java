package ec.edu.ups.appdis.g1.modelo;
/**
 * Importamos los administradores de entidad 
 *  la anotación @Persistence es utilizada en la clase 
 *  JPAclaseDao para inyectar automáticamente el EntityManager.
 */
import java.io.Serializable;
import java.util.Date;

import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Cuenta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * Anotacion @Entity 
 *esta anotación se debe de definir a 
 *nivel de clase y sirve únicamente para indicarle a JPA
 */
@Entity
public class Transaccion implements Serializable{
	private static final long serialVersionUID=1L;
	/**
	 * Anotación @Id
	 * puede ser cualquier tipo de datos soportado por JPA, 
	 * Anotación@GeneratedValue 
	 * con JPA es algo bastante habitual ya que existen muchas tablas 
	 * cuyas claves primarias preferimos que sean autoincrementales.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransaccion;
	/**
	 * Anotación @Temporal
	 * es posible mapear las fechas con la base de datos de una forma simple
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private String tipoTransaccion;
	private double monto;
	/**
	 * @ManyToOne encarga de generar una relación de muchos a uno 
	 * @JoinColumn:hace referencia a la columna que es clave externa en la tabla y define la relación
	 */
	@ManyToOne
	@JoinColumn
	private Cuenta cuenta;
	/**
	 * Generar Getters and Setters
	 * @return
	 */
	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
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
