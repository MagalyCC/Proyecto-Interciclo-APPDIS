package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.AdministrativoDAO;
import ec.edu.ups.appdis.g1.DAO.ClienteDAO;
import ec.edu.ups.appdis.g1.modelo.Administrativo;
import ec.edu.ups.appdis.g1.modelo.Persona;

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
	public List<Administrativo> buscarCliente(String cedula){
		return  daoAdministrativo.getClientes(cedula);
	}
}
