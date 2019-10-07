package core.ds;

import java.util.Date;
import java.util.Timer;

public class Reloj {
    Date fecha;
    Timer timer;

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha(){
        return fecha;
    }
}
