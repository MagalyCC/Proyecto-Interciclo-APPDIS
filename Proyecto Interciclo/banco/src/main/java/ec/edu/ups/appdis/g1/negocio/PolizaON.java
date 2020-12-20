package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.ParametrosPolizaDAO;
import ec.edu.ups.appdis.g1.DAO.UsuarioDAO;
import ec.edu.ups.appdis.g1.modelo.ParametrosPoliza;

public class PolizaON {
	@Inject
	private ParametrosPolizaDAO daoParametros;
	public ParametrosPoliza buscarParametros(int idPoliza) throws Exception {
		
		try {
			return  daoParametros.read(idPoliza);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
	}
	public List<ParametrosPoliza> buscarParametrosLista(){
		return  daoParametros.getParametros();
	}
}
