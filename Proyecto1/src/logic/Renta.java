/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import java.util.*;
/**
 *
 * @author Jaime Andara
 */
public class Renta extends Transaccion{
    
    protected int cantidad_de_dias;
    protected final double precio_renta_peliculas = 7;
    private final double precio_renta_series = 5;
    protected double renta_final_peliculas;
    protected double renta_final_series;
    protected boolean mora;
    protected Date fecha_renta;
    
    
    public Renta(String nombre_venta_renta, String busqueda_codigo, String usuario
            , String turno, String email, int cantidad_final, Date fecha_renta, boolean mora) {
        super(nombre_venta_renta,busqueda_codigo,usuario,turno,email,cantidad_final);
        this.mora = mora;
        this.fecha_renta = fecha_renta;
    }
    
    public Renta(){
        
    }

    public int obtener_Cantidad_de_dias() {
        return cantidad_de_dias;
    }

    public void establecer_Cantidad_de_dias(int cantidad_de_dias) {
        this.cantidad_de_dias = cantidad_de_dias;
    }

    public double pagar_Renta_Peliculas(int cantidad, int dias , double agregado) {
        agregado = 0.50;
        if(dias > 0 && dias < 3){
        this.renta_final_peliculas = (cantidad*precio_renta_peliculas);    
        }else{
            this.renta_final_peliculas = (cantidad*precio_renta_peliculas*agregado);
        }
        return this.renta_final_peliculas;
    }
    
    public double pagar_Renta_Series(int cantidad, int dias , double agregado){
        agregado = 0.50;
        if(dias > 0 && dias < 3){
        this.renta_final_peliculas = (cantidad*precio_renta_series);    
        }else{
            this.renta_final_series = (cantidad*precio_renta_series*agregado);
        }
        return this.renta_final_series;
    }
    
    public Date obtener_Fecha_renta() {
        return fecha_renta;
    }

    public void establecer_Fecha_renta(int año, int mes, int dia) {
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes-1, dia);
        this.fecha_renta = calendario.getTime();
    }
       
}