package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Transferencia;
/**
 * 
 * anotación @Stateless es la que lo convierte en un EJB y 
 * le indica al contenedor de aplicaciones que debe encargarse de manejarlo
 *
 */
@Stateless
public class TransferenciaDAO {
	/**
	 * anotación @Inject identifica un punto el cual una dependencia en una clase o interfaz 
	 * Java puede ser inyectada en una clase destino
	 */
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	/**
	 * Metodo de Insertar Datos
	 * @param entity
	 * @throws Exception
	 */
	public void insert(Transferencia entity) throws Exception {
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
 * Metodo de Buscar Datos
 * @param id
 * @return
 * @throws Exception
 */
	// DAO buscar
	public Transferencia read(int id) throws Exception {
		try {
			return em.find(Transferencia.class, id);
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
	public List<Transferencia> getClientes(int id) {
		String jpql = "Select c from Transferencia c ";
		Query q = em.createQuery(jpql, Transferencia.class);
		return (List<Transferencia>) q.getResultList();
	}
}
