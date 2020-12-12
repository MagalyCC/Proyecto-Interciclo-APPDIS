package ec.edu.ups.appdis.g1.negocio;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.appdis.g1.modelo.Administrativo;

@Remote
public interface AdministrativoONRemoto {
	public boolean registrarAdministrativo(Administrativo administrativo)throws Exception;

	public List<Administrativo> buscarCliente(String cedula);
}
