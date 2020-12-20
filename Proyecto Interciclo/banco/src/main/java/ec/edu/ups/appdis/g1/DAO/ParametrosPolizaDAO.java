package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;
import ec.edu.ups.appdis.g1.modelo.Usuario;

@Stateless
public class ParametrosPolizaDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;
	public ParametrosPoliza read(int id) throws Exception {
		try {
			return em.find(ParametrosPoliza.class, id);
		} catch (Exception e) {
			throw new Exception("Erro buscar parametroz poliza " + e.getMessage());
		}
	}
	public List<ParametrosPoliza> getParametros() {
		String jpql= "Select c from ParametrosPoliza c ";
		Query q = em.createQuery(jpql, ParametrosPoliza.class);
		return (List<ParametrosPoliza>) q.getResultList();
	}
}
