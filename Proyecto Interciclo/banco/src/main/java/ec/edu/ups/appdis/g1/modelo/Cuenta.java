package ec.edu.ups.appdis.g1.modelo;

/**
 * Importamos librerias que Contiene otras clases útiles que ayudan al programador
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Importamos la clase Persona del paquete modelo
 */
import ec.edu.ups.appdis.g1.modelo.Persona;
/**
 * Importamos los administradores de entidad 
 *  la anotación @Persistence es utilizada en la clase 
 *  JPAclaseDao para inyectar automáticamente el EntityManager.
 */
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * Anotacion @Entity 
 *esta anotación se debe de definir a 
 *nivel de clase y sirve únicamente para indicarle a JPA
 */
@Entity
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Anotación @Id
	 * puede ser cualquier tipo de datos soportado por JPA, 
	 * Anotación@GeneratedValue 
	 * con JPA es algo bastante habitual ya que existen muchas tablas 
	 * cuyas claves primarias preferimos que sean autoincrementales.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuenta;
	/**
	 * Anotación @Temporal
	 * es posible mapear las fechas con la base de datos de una forma simple
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	private String tipo;
	private double saldo;
	/**
	 * @ManyToOne encarga de generar una relación de muchos a uno 
	 * @JoinColumn:hace referencia a la columna que es clave externa en la tabla y define la relación
	 */
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	/**
	 * @OneToMany por Entidad donde tenemos un objeto principal y colección de objetos de otra Entidad 
	 * relacionados directamente.
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
	private List<Poliza> poliza = new ArrayList<Poliza>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
	private List<Transferencia> transferencia = new ArrayList<Transferencia>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
	private List<Transaccion> transaccion = new ArrayList<Transaccion>();
/**
 * Generar Getters and Setters
 * @return
 */
	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Poliza> getPoliza() {
		return poliza;
	}

	public void setPoliza(List<Poliza> poliza) {
		this.poliza = poliza;
	}

	public List<Transferencia> getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(List<Transferencia> transferencia) {
		this.transferencia = transferencia;
	}

	public List<Transaccion> getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(List<Transaccion> transaccion) {
		this.transaccion = transaccion;
	}

}
