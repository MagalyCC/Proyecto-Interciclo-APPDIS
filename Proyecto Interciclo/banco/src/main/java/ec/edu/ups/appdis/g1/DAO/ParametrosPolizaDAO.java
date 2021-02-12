package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Poliza;
import ec.edu.ups.appdis.g1.modelo.Usuario;
/**
 * 
 * anotación @Stateless es la que lo convierte en un EJB y 
 * le indica al contenedor de aplicaciones que debe encargarse de manejarlo
 *
 */
@Stateless
public class ParametrosPolizaDAO {
	/**
	 * anotación @Inject identifica un punto el cual una dependencia en una clase o interfaz 
	 * Java puede ser inyectada en una clase destino
	 */
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	/**
	 * Metodo para buscar Datos
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ParametrosPoliza read(int id) throws Exception {
		try {
			return em.find(ParametrosPoliza.class, id);
		} catch (Exception e) {
			throw new Exception("Erro buscar parametroz poliza " + e.getMessage());
		}
	}

	public List<ParametrosPoliza> getParametros() {
		String jpql = "Select c from ParametrosPoliza c ";
		Query q = em.createQuery(jpql, ParametrosPoliza.class);
		return (List<ParametrosPoliza>) q.getResultList();
	}

	/**
	 * Metodo de actualizar Datos
	 * @param parametro
	 * @throws Exception
	 */
	public void updateJPA(ParametrosPoliza parametro) throws Exception {
		try {
			em.merge(parametro);
		} catch (Exception e) {
			throw new Exception("Erro actualizar Cliente " + e.getMessage());
		}
	}

	/**
	 * Metodo de Eliminar Datos
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
	public boolean insertJPA(ParametrosPoliza entity) throws SQLException {
		em.persist(entity);
		return true;
	}
	
	public List<ParametrosPoliza> getPoliza(int plazo) {
		String jpql = "Select c from ParametrosPoliza c where diaMin<="+plazo+"and diaMax>="+plazo;
		Query q = em.createQuery(jpql, ParametrosPoliza.class);
		return (List<ParametrosPoliza>) q.getResultList();
	}
}
