package ec.edu.ups.appdis.g1.negocio;

import ec.edu.ups.appdis.g1.modelo.Administrativo;
import java.util.List;


public interface AdministrativoONRemoto {
	public boolean registrarAdministrativo(Administrativo administrativo)throws Exception;
        public String existeAdmistrador(String usuario, String password);
        public List<Administrativo> buscarCliente(String cedula);

}
