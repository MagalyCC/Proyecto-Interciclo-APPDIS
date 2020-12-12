package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Administrativo;

@Stateless
public class AdministrativoDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;
	
	public boolean insert(Administrativo administrativo) throws Exception {
        boolean bandera = true;
    	try {
            System.out.println("Ingresa Administrativo");
            em.persist(administrativo);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso Administrativo " + e.getMessage());
            
        }
        
        return bandera;
    }
	
		
	public List<Administrativo> getClientes(String cedula) {
		String jpql= "Select c from Administrativo c where c.cedula =?1";
		Query q = em.createQuery(jpql, Administrativo.class);
		q.setParameter(1, cedula);
		return (List<Administrativo>) q.getResultList();
	}
}
