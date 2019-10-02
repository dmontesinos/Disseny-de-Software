package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado {
    public static void main(String[] args) {
        /*Empleado empleado1 = new Empleado("Daniel", 2000, 2019, 11,23);
        Empleado empleado2 = new Empleado("Daniel2", 3000, 2015, 1,3);
        Empleado empleado3 = new Empleado("Daniel3", 4000, 2012, 12,12);

        System.out.println(empleado1.getNombre());
        System.out.println(empleado1.getSueldo());
        empleado1.subeSueldo(10);
        System.out.println(empleado1.getSueldo());


        System.out.println("El empleado "+empleado1.getNombre()+" tiene un salario de "+empleado1.getSueldo()+" en el año de contrato "+ empleado1.getAltaContrato());*/

        /*ARRAY DE EMPLEADOS*/
        /*Empleado[] empleados = new Empleado[3];

        empleados[0] = new Empleado("Daniel", 2000, 2019, 11,23);
        empleados[1] = new Empleado("Daniel2", 3000, 2015, 1,3);
        empleados[2] = new Empleado("Daniel3", 4000, 2012, 12,12);

        System.out.println(empleados[1].getNombre());*/

        /*
        //EMPLEADO CON CONSTRUCTOR MODIFICADO//
        Empleado empleado1 = new Empleado("Danieh");
        System.out.println(empleado1.getNombre()+" "+empleado1.getSueldo());*/
    }
}

class Empleado{
    public Empleado(String nom, double sue, int agno, int mes, int dia){
        nombre = nom;
        sueldo = sue;

        GregorianCalendar calendario = new GregorianCalendar(agno, mes-1,dia);
        altaContrato = calendario.getTime();
    }

    public Empleado(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public double getSueldo(){
        return sueldo;
    }

    public Date getAltaContrato(){
        return altaContrato;
    }

    public void subeSueldo(double porcentaje){
        double aumento = sueldo*porcentaje/100;
        sueldo += aumento;
    }

    private String nombre;
    private double sueldo;
    private Date altaContrato;
}