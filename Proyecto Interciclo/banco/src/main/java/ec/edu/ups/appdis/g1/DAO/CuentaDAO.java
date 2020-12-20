package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;

@Stateless
public class CuentaDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public void insert(Cuenta entity) throws Exception {
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
	public Cuenta read(int id) throws Exception {
		try {
			return em.find(Cuenta.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}

	// DAO buscar devuelve lista
	/*public List<Persona> getCuenta(String correo) {
		String jpql = "Select p from Persona p where p.email=?1";
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter(1, correo);
		return (List<Persona>) q.getResultList();
	}*/
	public Persona getCuenta(String correo) {
		String jpql = "Select p from Persona p where p.email='"+correo+"'";
		Persona per = (Persona) em.createQuery(jpql).getSingleResult();
		System.out.println(per.getApellido());
		return per;
	}
	/*public int getUsuario(String correo) {
		String jpql = "Select p from Persona p where p.email='"+correo+"'";
		Persona per = (Persona) em.createQuery(jpql).getSingleResult();
		System.out.println(per.getApellido());
		return per.getUsuario().getIdUsuario();
	}
	public List<Cuenta> getCuenta(int idUsuario) {
		
		String jpql = "Select p from Usuario p where p.idUsuario="+idUsuario+"";
		Usuario per = (Usuario) em.createQuery(jpql).getSingleResult();
		//System.out.println(per.getCuenta());
		return per.getCuenta();
	}*/
	
}
