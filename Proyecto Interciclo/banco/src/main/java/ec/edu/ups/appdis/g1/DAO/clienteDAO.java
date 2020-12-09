package ec.edu.ups.appdis.g1.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.g1.modelo.cliente;

@Stateless
public class clienteDAO {
	private EntityManager em;

    public clienteDAO() {
    }
     /**
     * Inserta el login mediante el numero el objeto de cliente.
     * @param cliente
     * @return si inserto o no.
     */
    
    public boolean insert(cliente cliente) throws Exception {
        boolean bandera = true;
    	try {
            System.out.println("si creo que llega aca");
            em.persist(cliente);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso Cliente " + e.getMessage());
            
        }
        
        return bandera;
    }

}
