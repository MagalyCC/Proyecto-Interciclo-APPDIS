package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Transferencia;

@Stateless
public class TransferenciaDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public void insert(Transferencia entity) throws Exception {
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
	public Transferencia read(int id) throws Exception {
		try {
			return em.find(Transferencia.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}

	// DAO buscar devuelve lista
	public List<Transferencia> getClientes(int id) {
		String jpql = "Select c from Transferencia c ";
		Query q = em.createQuery(jpql, Transferencia.class);
		return (List<Transferencia>) q.getResultList();
	}
}
