package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Persona;

@Stateless
public class PersonaDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public void insert(Persona persona) throws Exception {
		try {
			em.persist(persona);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Cliente " + e.getMessage());

		}
	}

	// DAO borrar
	public void deleteId(String cedula) throws Exception {
		try {
			em.remove(read(cedula));
		} catch (Exception e) {
			throw new Exception("Error Eliminar Cliente " + e.getMessage());
		}
	}

	// DAO buscar
	public Persona read(String cedula) throws Exception {
		try {
			return em.find(Persona.class, cedula);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}

	// DAO buscar devuelve lista
	public List<Persona> getClientes(String cedula) {
		String jpql = "Select c from Persona c ";
		Query q = em.createQuery(jpql, Persona.class);
		return (List<Persona>) q.getResultList();
	}
	
	public List<Persona> existePersona(String cedula) {
		String jpql= "Select c from Persona c where c.cedula =?1";
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter(1, cedula);
		return (List<Persona>) q.getResultList();
	}
}
