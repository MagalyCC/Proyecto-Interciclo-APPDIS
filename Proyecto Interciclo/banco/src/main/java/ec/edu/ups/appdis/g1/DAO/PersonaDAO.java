package ec.edu.ups.appdis.g1.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Documentos;
import ec.edu.ups.appdis.g1.modelo.Persona;

/**
 * 
 * anotación @Stateless es la que lo convierte en un EJB y 
 * le indica al contenedor de aplicaciones que debe encargarse de manejarlo
 *
 */
@Stateless
public class PersonaDAO {
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
	 * @param persona
	 * @throws Exception
	 */
	public void insert(Persona entity) throws Exception {
		try {
			em.persist(entity);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Cliente " + e.getMessage());

		}
	}
	public void updateJPA(Persona entity) throws Exception {
		try {
			em.merge(entity);
		} catch (Exception e) {
			throw new Exception("Erro actualizar Cliente " + e.getMessage());
		}
	}
	/**
	 * Metodo de Borrar Datos
	 * @param cedula
	 * @throws Exception
	 */
	// DAO borrar
	public void deleteId(String cedula) throws Exception {
		try {
			em.remove(read(cedula));
		} catch (Exception e) {
			throw new Exception("Error Eliminar Cliente " + e.getMessage());
		}
	}

	/**
	 * Metodo de Buscar Datos
	 * @param cedula
	 * @return
	 * @throws Exception
	 */
	// DAO buscar
	public Persona read(String cedula) throws Exception {
		try {
			return em.find(Persona.class, cedula);
		} catch (Exception e) {
			throw new Exception("Erro leer Cliente " + e.getMessage());
		}
	}

	/**
	 * buscar devuelve lista
	 * @param cedula
	 * @return
	 */
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
	
	/*public void guardaArchivo(String ruta) throws SQLException, FileNotFoundException
	{
	String sql = "INSERT INTO Documentos VALUES  (1,?)";
	//Creamos una cadena para después prepararla
	PreparedStatement stmt = con.prepareStatement(sql);
	File archivo = new File(ruta);
	//ruta puede ser: "c://archivo"
	FileInputStream fis = new FileInputStream(archivo);
	//Lo convertimos en un Stream
	Object a = stmt.setBinaryStream(1, fis, (int) archivo.length());
	//Asignamos el Stream al Statement
	stmt.execute();
	Documentos d=new Documentos();
	d.setPdfC(fis);
	}
	public void insertD(Documentos persona) throws Exception {
		try {
			em.persist(persona);
		} catch (Exception e) {
			throw new Exception("Erro ingreso Cliente " + e.getMessage());

		}
	}*/
	
}
