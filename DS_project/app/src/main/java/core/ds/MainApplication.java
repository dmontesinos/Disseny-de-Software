package DS.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApplication {

   static Logger logger = LoggerFactory.getLogger(MainApplication.class);
     public static void main(final String[] args) {
        System.out.println("Hola mundo!");
        logger.debug("mensaje que no aparece");
        logger.info("este mensaje si aparece");


    }
}