/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.g1.vista;

import ec.edu.ups.appdis.g1.negocio.AdministrativoONRemoto;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author aloja
 */
public class Referencia {

    private AdministrativoONRemoto on;

    public void referenciarONAdministrativo() throws Exception {
        try {
            final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "pepe");
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "pepe");

            final Context context = new InitialContext(jndiProperties);

            final String lookupName = "ejb:/banco/AdministrativoON!ec.edu.ups.appdis.g1.negocio.AdministrativoONRemoto";

            this.on = (AdministrativoONRemoto) context.lookup(lookupName);

        } catch (Exception ex) {
            System.out.println("hola");
        }
    }
}
