package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * anotación @Stateless es la que lo convierte en un EJB y 
 * le indica al contenedor de aplicaciones que debe encargarse de manejarlo
 *
 */
@Stateless
public class ValidacionesDAO {
	/**
	 * anotación @Inject identifica un punto el cual una dependencia en una clase o interfaz 
	 * Java puede ser inyectada en una clase destino
	 */
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;
	
	/**
	 * validacion campo de cedula
	 * @param cedula
	 * @return
	 */
	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;
		 int c, suma=0, acum, resta=0;
        
        for (int i = 0; i < cedula.length()-1; i++) {
            c=Integer.parseInt(cedula.charAt(i)+"");
            if(i%2==0){
                c=c*2;
                if(c>9){
                    c=c-9;
                }
            }
            
            suma=suma+c;
        }
        
        if (suma%10 !=0) {
            acum=((suma/10)+1)*10;
            resta=acum-suma;
        }
        
        int ultimo=Integer.parseInt(cedula.charAt(9)+"");
        
        if (ultimo==resta) {
            System.out.println("la cédula ingresa es correcta");
        }else{
            System.out.println("la cedula es incorrecta");
        }
		return cedulaCorrecta;
		}
	
   
    
    
        /**
         * validacion de campo correo
         * @param correo
         * @return
         */
	  public boolean esCorreo(String correo){
	        Pattern patroncito = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	        Matcher comparar=patroncito.matcher(correo);
	                    if(comparar.find()==true){
	                        System.out.println("correo es correo\n");
	                    }
	                    else{
	                        System.out.println(" correo incorrecto\n");
	                    }
	        return comparar.find();
	    }
        
        
        
        
        /**
         * validacion campo letras	
         * @param cadena
         * @return
         */
    	static boolean SoloLetras(String cadena){
    		for (int i = 0; i < cadena.length(); i++){
    			char caracter = cadena.toUpperCase().charAt(i);
    			int valorASCII = (int)caracter;
    			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) 
    				return false; //Se ha encontrado un caracter que no es letra
    			}
    		return true;
    	}
}
