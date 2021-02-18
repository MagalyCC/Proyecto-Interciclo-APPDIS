package ec.edu.ups.appdis.g1.modelo;
/**
 * Importamos los administradores de entidad 
 *  la anotación @Persistence es utilizada en la clase 
 *  JPAclaseDao para inyectar automáticamente el EntityManager.
 */
import java.io.Serializable;
import java.util.Date;
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
public class Transferencia implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Anotación @Id puede ser cualquier tipo de datos soportado por JPA
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCodigo;
	private double monto;
	/**
	 * @ManyToOne encarga de generar una relación de muchos a uno
	 * @JoinColumn:hace referencia a la columna que es clave externa en la tabla y
	 *                  define la relación
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	@ManyToOne
	@JoinColumn
	private Cuenta cuentaenvia;
	@ManyToOne
	@JoinColumn
	private Cuenta cuentarecibe;
	private String cuentaTercero;

	/**
	 * Generar Getters and Setters
	 * 
	 * @return
	 */

	public int getIdCodigo() {
		return idCodigo;
	}

	public String getCuentaTercero() {
		return cuentaTercero;
	}

	public void setCuentaTercero(String cuentaTercero) {
		this.cuentaTercero = cuentaTercero;
	}

	public void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Cuenta getCuentaenvia() {
		return cuentaenvia;
	}

	public void setCuentaenvia(Cuenta cuentaenvia) {
		this.cuentaenvia = cuentaenvia;
	}

	public Cuenta getCuentarecibe() {
		return cuentarecibe;
	}

	public void setCuentarecibe(Cuenta cuentarecibe) {
		this.cuentarecibe = cuentarecibe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
