
import java.util.Date;

import static java.lang.Thread.sleep;

public class Fechas {
    public static void main(String[] args) throws InterruptedException {
        Date fechaUltimaSincro = new Date();
        sleep(2000);
        Date fechaActual = new Date();

        double dias=(double) ((fechaActual.getTime()-fechaUltimaSincro.getTime()));

        System.out.println("Hay "+dias+" dias de diferencia");
    }




}
