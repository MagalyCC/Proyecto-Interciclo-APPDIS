package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Usuario;
/**
 * 
 * anotación @Stateless es la que lo convierte en un EJB y 
 * le indica al contenedor de aplicaciones que debe encargarse de manejarlo
 *
 */
@Stateless
public class UsuarioDAO {
	/**
	 * anotación @Inject identifica un punto el cual una dependencia en una clase o interfaz 
	 * Java puede ser inyectada en una clase destino
	 */
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	/**
	 * Metodo de Insertar Datos
	 * @param entity
	 * @throws Exception
	 */
	public void insert(Usuario entity) throws Exception {
		try {
			em.persist(entity);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Cliente " + e.getMessage());

		}
	}

	/**
	 * Metodo de Borrar Datos
	 * @param id
	 * @throws Exception
	 */
	public void deleteId(String id) throws Exception {
		try {
			em.remove(read(id));
		} catch (Exception e) {
			throw new Exception("Error Eliminar Cliente " + e.getMessage());
		}
	}

	/*
	 * Metodo buscar Datos
	 */
	public Usuario read(String correo) throws Exception {
		try {
			return em.find(Usuario.class, correo);
		} catch (Exception e) {
			throw new Exception("Erro buscar correo " + e.getMessage());
		}
	}

	/**
	 * buscar devuelve lista
	 * @param correo
	 * @return
	 */
	
	public Persona getUsuarios(String correo) {
		String jpql = "Select p from Persona p where p.email='"+correo+"'";
		Persona per = (Persona) em.createQuery(jpql).getSingleResult();
		return per;
	}
}
