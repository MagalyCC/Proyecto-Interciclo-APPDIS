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
/**
 * 
 * Anotacion @Entity 
 *esta anotación se debe de definir a 
 *nivel de clase y sirve únicamente para indicarle a JPA
 */
@Entity
public class Transferencia implements Serializable{
	private static final long serialVersionUID=1L;
	/**
	 * Anotación @Id
	 * puede ser cualquier tipo de datos soportado por JPA
	 */
	@Id
	private int idCodigo;
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
	public int getIdCodigo() {
		return idCodigo;
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
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
	
}
