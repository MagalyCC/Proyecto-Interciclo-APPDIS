package ec.edu.ups.appdis.g1.modelo;
/**
 * Importamos los administradores de entidad 
 *  la anotación @Persistence es utilizada en la clase 
 *  JPAclaseDao para inyectar automáticamente el EntityManager.
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
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
public class Poliza implements Serializable{
	private static final long serialVersionUID=1L;
	/**
	 * Anotación @Id
	 * puede ser cualquier tipo de datos soportado por JPA
	 */
	@Id
	private int idPoliza;
	/**
	 * Anotación @Temporal
	 * es posible mapear las fechas con la base de datos de una forma simple
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private double interes;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdPoliza() {
		return idPoliza;
	}
	public void setIdPoliza(int idPoliza) {
		this.idPoliza = idPoliza;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
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
