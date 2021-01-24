package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Ingreso;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.Usuario;
/**
 * 
 * anotación @Stateless es la que lo convierte en un EJB y 
 * le indica al contenedor de aplicaciones que debe encargarse de manejarlo
 *
 */
@Stateless
public class IngresoDAO {
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
	public void insert(Ingreso entity) throws Exception {
		try {
			em.persist(entity);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Registro" + e.getMessage());

		}
	}

	public List<Ingreso> getIngresos(int id) {
		String jpql = "Select c from Ingreso c where c.usuario.idUsuario=?1";
		Query q = em.createQuery(jpql, Ingreso.class);
		q.setParameter(1, id);
		return (List<Ingreso>) q.getResultList();
	}
}
