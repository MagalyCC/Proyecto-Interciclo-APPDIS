package ec.edu.ups.appdis.g1.modelo;
/**
 * Importamos los administradores de entidad 
 *  la anotación @Persistence es utilizada en la clase 
 *  JPAclaseDao para inyectar automáticamente el EntityManager.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * Anotacion @Entity 
 *esta anotación se debe de definir a 
 *nivel de clase y sirve únicamente para indicarle a JPA
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Anotación @Id
	 * puede ser cualquier tipo de datos soportado por JPA, 
	 * Anotación@GeneratedValue 
	 * con JPA es algo bastante habitual ya que existen muchas tablas 
	 * cuyas claves primarias preferimos que sean autoincrementales.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	private String rol;
	private String password;
	private int estadoEliminado;
	private int estadoCuenta;
	/**
	 * @OneToOne se utiliza para definir una relación uno a uno entre las dos clases
	 * @JoinColumn:hace referencia a la columna que es clave externa en la tabla y define la relación
	 */
	@OneToOne
	@JoinColumn
	private Persona persona;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Ingreso> ingreso=new ArrayList<Ingreso>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Cuenta> cuenta=new ArrayList<Cuenta>();
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEstadoEliminado() {
		return estadoEliminado;
	}
	public void setEstadoEliminado(int estadoEliminado) {
		this.estadoEliminado = estadoEliminado;
	}
	public int getEstadoCuenta() {
		return estadoCuenta;
	}
	public void setEstadoCuenta(int estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	public List<Ingreso> getIngreso() {
		return ingreso;
	}
	public void setIngreso(List<Ingreso> ingreso) {
		this.ingreso = ingreso;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Cuenta> getCuenta() {
		return cuenta;
	}
	public void setCuenta(List<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
