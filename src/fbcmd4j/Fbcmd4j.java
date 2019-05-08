/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fbcmd4j;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sethtv10
 */
public class Fbcmd4j {

    /**
     * @param args the command line arguments
     */
    private static final Logger logger = LogManager.getLogger(Fbcmd4j.class);
    
    public static void main(String[] args) throws FacebookException, MalformedURLException {
        logger.info("Inicializando app");
        FacebookImp facebookImp = new FacebookImp();
        logger.info("publicando desde la app");
        facebookImp.Publish(facebookImp.facebook, "Este es un Mensaje Enviado desde Facebook4J");
        logger.info("publicando url desde la app");
        facebookImp.PublishURL(facebookImp.facebook);
        logger.info("Obteniendo feed desde la app");
        facebookImp.getFeed(facebookImp.facebook, "294564821251610");
        logger.info("Obteniendo Home desde la app");
        facebookImp.getHome(facebookImp.facebook);
        logger.info("Finalizando app");
    }
    
}
