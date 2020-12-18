package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Usuario;

@Stateless
public class UsuarioDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public void insert(Usuario entity) throws Exception {
		try {
			em.persist(entity);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Cliente " + e.getMessage());

		}
	}

	// DAO borrar
	public void deleteId(String id) throws Exception {
		try {
			em.remove(read(id));
		} catch (Exception e) {
			throw new Exception("Error Eliminar Cliente " + e.getMessage());
		}
	}

	// DAO buscar
	public Usuario read(String id) throws Exception {
		try {
			return em.find(Usuario.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}

	// DAO buscar devuelve lista
	public List<Usuario> getClientes(String cedula) {
		String jpql = "Select c from Usuario c";
		Query q = em.createQuery(jpql, Usuario.class);
		return (List<Usuario>) q.getResultList();
	}
}
