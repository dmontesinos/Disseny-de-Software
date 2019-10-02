package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApplication {
    static Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        System.out.println("Esto ya funciona correctamente");

        logger.debug("Mensaje que no aparece");
        logger.info("Este mensaje si que aparece");
    }
}
