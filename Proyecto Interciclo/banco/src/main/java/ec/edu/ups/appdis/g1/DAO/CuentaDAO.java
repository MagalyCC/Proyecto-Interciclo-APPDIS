package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Poliza;
import ec.edu.ups.appdis.g1.modelo.Usuario;
/**
 * 
 * anotación @Stateless es la que lo convierte en un EJB y 
 * le indica al contenedor de aplicaciones que debe encargarse de manejarlo
 *
 */
@Stateless
public class CuentaDAO {
	/**
	 * anotación @Inject identifica un punto el cual una dependencia en una clase o interfaz 
	 * Java puede ser inyectada en una clase destino
	 */
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	/**
	 * Metodo para Insertar Datos
	 * @param entity
	 * @throws Exception
	 */
	public void insert(Cuenta entity) throws Exception {
		try {
			em.persist(entity);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Cliente " + e.getMessage());

		}
	}

	
/**
 * Metodo para Borrar Datos
 * @param id
 * @throws Exception
 */
	public void deleteId(int id) throws Exception {
		try {
			em.remove(read(id));
		} catch (Exception e) {
			throw new Exception("Error Eliminar Cliente " + e.getMessage());
		}
	}

	/**
	 * Metodo para Buscar Datos
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Cuenta read(int id) throws Exception {
		try {
			return em.find(Cuenta.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}
	
/**
 * Retorna 
 * @param correo
 * @return
 */
	public Persona getCuenta(String correo) {
		String jpql = "Select p from Persona p where p.email='" + correo + "'";
		Persona per = (Persona) em.createQuery(jpql).getSingleResult();
		System.out.println(per.getApellido());
		return per;
	}
	
/**
 * Listar Cuentas
 * @param id
 * @return
 */
	public List<Cuenta> getIdCuentas(int id) {
		String jpql = "Select c from Cuenta c where c.usuario=" + id + "";
		Query q = em.createQuery(jpql, Cuenta.class);
		return (List<Cuenta>) q.getResultList();
	}
	
	/**
	 * Metodo para Modificar Registro
	 * @param cuenta
	 * @throws Exception
	 */

	public void updateJPA(Cuenta cuenta) throws Exception {
		try {
			em.merge(cuenta);
		} catch (Exception e) {
			throw new Exception("Erro actualizar Cliente " + e.getMessage());
		}
	}

}
