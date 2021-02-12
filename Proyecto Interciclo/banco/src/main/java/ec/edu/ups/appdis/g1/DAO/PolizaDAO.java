package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Poliza;

@Stateless
public class PolizaDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public void insert(Poliza entity) throws Exception {
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
	public Poliza read(int id) throws Exception {
		try {
			return em.find(Poliza.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}

	// DAO buscar devuelve lista
	public List<Poliza> getPoliza(int plazo) {
		String jpql = "Select c from Poliza c where diaMin<"+plazo+"and diaMax>"+plazo;
		Query q = em.createQuery(jpql, Poliza.class);
		return (List<Poliza>) q.getResultList();
	}
}
