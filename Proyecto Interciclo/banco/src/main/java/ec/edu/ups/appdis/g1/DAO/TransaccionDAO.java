package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Transaccion;
/**
 * 
 * anotación @Stateless es la que lo convierte en un EJB y 
 * le indica al contenedor de aplicaciones que debe encargarse de manejarlo
 *
 */
@Stateless
public class TransaccionDAO {
	/**
	 * anotación @Inject identifica un punto el cual una dependencia en una clase o interfaz 
	 * Java puede ser inyectada en una clase destino
	 */
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	/**
	 * Metodo de insertat Datos
	 * @param entity
	 * @throws Exception
	 */
	public void insert(Transaccion entity) throws Exception {
		try {
			em.persist(entity);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Cliente " + e.getMessage());

		}
	}

	/**
	 * Metodo de Borrar Datos
	 * @param id
	 * @throws Exception
	 */
	// DAO borrar
	public void deleteId(int id) throws Exception {
		try {
			em.remove(read(id));
		} catch (Exception e) {
			throw new Exception("Error Eliminar Cliente " + e.getMessage());
		}
	}
/**
 * Metodo para Buscar
 * @param id
 * @return
 * @throws Exception
 */
	// DAO buscar
	public Transaccion read(int id) throws Exception {
		try {
			return em.find(Transaccion.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}
/**
 * buscar devuelve lista
 * @param id
 * @return
 */
	// DAO buscar devuelve lista
	public List<Transaccion> getTransacciones(int id) {
		String jpql = "Select c from Transaccion c where c.cuenta.idCuenta=?1";
		Query q = em.createQuery(jpql, Transaccion.class);
		q.setParameter(1, id);
		return (List<Transaccion>) q.getResultList();
	}
}
