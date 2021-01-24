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
public class Ingreso implements Serializable{
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
	private int idIngreso;
	private String intento;
	/**
	 * Anotación @Temporal
	 * es posible mapear las fechas con la base de datos de una forma simple
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	/**
	 * @ManyToOne encarga de generar una relación de muchos a uno 
	 * @JoinColumn:hace referencia a la columna que es clave externa en la tabla y define la relación
	 */
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	/**
	 * Generar Getters and Setters
	 * @return
	 */
	public int getIdIngreso() {
		return idIngreso;
	}
	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getIntento() {
		return intento;
	}
	public void setIntento(String intento) {
		this.intento = intento;
	}	
}
