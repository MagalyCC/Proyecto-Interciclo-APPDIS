package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

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
            System.out.println("si creo que llega aca");
            em.persist(administrativo);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso Cliente " + e.getMessage());
            
        }
        
        return bandera;
    }
}
