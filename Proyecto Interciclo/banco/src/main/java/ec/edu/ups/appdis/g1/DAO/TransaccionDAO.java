package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Transaccion;

@Stateless
public class TransaccionDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public void insert(Transaccion entity) throws Exception {
		try {
			em.persist(entity);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Cliente " + e.getMessage());

		}
	}

	// DAO borrar
	public void deleteId(int id) throws Exception {
		try {
			em.remove(read(id));
		} catch (Exception e) {
			throw new Exception("Error Eliminar Cliente " + e.getMessage());
		}
	}

	// DAO buscar
	public Transaccion read(int id) throws Exception {
		try {
			return em.find(Transaccion.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}

	// DAO buscar devuelve lista
	public List<Transaccion> getClientes(int id) {
		String jpql = "Select c from Transaccion c";
		Query q = em.createQuery(jpql, Transaccion.class);
		return (List<Transaccion>) q.getResultList();
	}
}
