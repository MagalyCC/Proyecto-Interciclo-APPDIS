package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.AdministrativoDAO;
import ec.edu.ups.appdis.g1.DAO.ClienteDAO;
import ec.edu.ups.appdis.g1.modelo.Administrativo;
import ec.edu.ups.appdis.g1.modelo.Cliente;

@Stateless
public class AdministrativoON implements AdministrativoONRemoto{
	@Inject
	private AdministrativoDAO daoAdministrativo;
	public boolean registrarAdministrativo(Administrativo administrativo) throws Exception {
		 if (administrativo.getCedula().length() != 10)
	            throw new Exception("La cedula no cumple con la longitud correcta");
	        try {
	        	daoAdministrativo.insert(administrativo);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new Exception("Error al registrar");
	        }
	        return true;
	    }
}
