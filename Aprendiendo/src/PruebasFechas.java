import java.util.Date;

import static java.lang.Thread.sleep;

public class PruebasFechas {
    public static void main(String[] args) throws InterruptedException{
        Date primera = new Date();
        sleep(3000);
        Date segunda = new Date();
        System.out.println(primera);
        System.out.println(segunda);

        long tfinal = (long)(segunda.getTime() - primera.getTime())/1000;
        System.out.println(tfinal);
    }
}
