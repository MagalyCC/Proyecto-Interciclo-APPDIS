package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Ingreso;

@Stateless
public class IngresoDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;
	public void insert(Ingreso entity) throws Exception {
		try {
			em.persist(entity);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Registro" + e.getMessage());

		}
	}
}
