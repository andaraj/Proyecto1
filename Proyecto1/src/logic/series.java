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
public class series {
    protected String nombre_series;
    protected String descripcion_series;
    protected String codigo_series;
    protected String director_series;
    protected String proovedor_series;
    protected int cantidad_serie;
    protected boolean disponibilidad_series = false;
    protected boolean busqueda = false;
    protected Date fecha_estreno_series;
    private final double precio_renta_series = 5;
    private double precio_venta_series = 15;
    private final long milis_por_dia = 86400000;

    public series(String nombre_series, String descripcion_series, String codigo_series, String director_series, String proovedor_series, int cantidad_serie, Date fecha_estreno_series) {
        this.nombre_series = nombre_series;
        this.descripcion_series = descripcion_series;
        this.codigo_series = codigo_series;
        this.director_series = director_series;
        this.proovedor_series = proovedor_series;
        this.cantidad_serie = cantidad_serie;
        this.fecha_estreno_series = fecha_estreno_series;
    }
    public series(){
        
    }
     
    public void establecer_Nombre_series(String nombre_series) {
        this.nombre_series = nombre_series;
    }

    public String obtener_Nombre_series() {
        return nombre_series;
    }
    
    public void establecer_Descripcion_series(String descripcion_series) {
        this.descripcion_series = descripcion_series;
    }

    public String obtener_Descripcion_series() {
        return descripcion_series;
    }
    
    public void establecer_Codigo_series(String codigo_series) {
        this.codigo_series = codigo_series;
    }

    public String obtener_Codigo_series() {
        return codigo_series;
    }
    
    public void setDirector_series(String director_series) {
        this.director_series = director_series;
    }

    public String obtener_Director_series() {
        return director_series;
    }
    
    public void establecer_Proovedor_series(String proovedor_series) {
        this.proovedor_series = proovedor_series;
    }

    public String obtener_Proovedor_series() {
        return proovedor_series;
    }
    
    public void establecer_Cantidad_serie(int cantidad_serie) {
        this.cantidad_serie = cantidad_serie;
    }

    public int obtener_Cantidad_serie() {
        return cantidad_serie;
    }
       
    public void establecer_Fecha_estreno_series(int año, int mes, int dia) {
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes-1, dia);
        this.fecha_estreno_series = calendario.getTime();
    }

    public Date obtener_Fecha_estreno_series() {
        return fecha_estreno_series;
    }
    public void establecer_Disponibilidad_series(boolean disponibilidad_series) {
        Date hoy = new Date();
        Calendar calendario = Calendar.getInstance();
        fecha_estreno_series = new Date(calendario.getTimeInMillis());
        long diferencia = (hoy.getTime()-fecha_estreno_series.getTime())/milis_por_dia;
        if(diferencia > 60){
            disponibilidad_series = true;
        }else{
            disponibilidad_series = false;
        }
    }

    public boolean obtener_Disponibilidad_series() {
        return disponibilidad_series;
    }

    public double obtener_precio_venta_series(){
        return precio_venta_series;
    }
    public double obtener_precio_renta_series(){
        return precio_renta_series;
    }
    
    /*public void Agregar_series(String nombre, String comentario){
        if(busqueda == true){
            System.out.println("La Serie ya esta Agregada");
        }else{
            listado_series.add(nombre);
            Agregar_descripcion_series(comentario);
        }
    }*/
}
