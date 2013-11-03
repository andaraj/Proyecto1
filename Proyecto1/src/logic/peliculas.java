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
public class peliculas {
    protected String nombre_pelicula;
    protected String codigo_peliculas;
    protected String director_peliculas;
    protected Date fecha_estreno_peliculas;
    protected String proovedor_peliculas;
    protected String descripcion_peliculas;
    protected Integer cantidad_pelicula;
    protected boolean disponibilidad_peliculas = false;
    protected boolean busqueda_pelicula = false;
    protected final double precio_venta_peliculas = 20;
    protected final double precio_renta_peliculas = 7;
    private final long milis_por_dia = 86400000;

    public peliculas(String codigo_peliculas, String director_peliculas, String proovedor_peliculas, String descripcion_peliculas, Integer cantidad_pelicula,Date fecha_estreno_peliculas) {
        this.codigo_peliculas = codigo_peliculas;
        this.director_peliculas = director_peliculas;
        this.proovedor_peliculas = proovedor_peliculas;
        this.descripcion_peliculas = descripcion_peliculas;
        this.cantidad_pelicula = cantidad_pelicula;
        this.fecha_estreno_peliculas = fecha_estreno_peliculas;
    }
    public peliculas(){
        
    }
    public double obtener_precio_venta_peliculas(){
        return precio_venta_peliculas;
    }
    public double obtener_precio_renta_peliculas(){
        return precio_renta_peliculas;
    }
    public void Agregar_descripcion_peliculas(String descripcion){
        this.descripcion_peliculas = descripcion;
    }
    public String obtener_descripcion_pelicula(){
        return descripcion_peliculas;
    }    
    public void Agregar_nombre_peliculas(String nombre){
        this.nombre_pelicula = nombre;
    }
    public String obtener_nombre_pelicula(){
       return nombre_pelicula;
   }
    
    public String obtener_Codigo_peliculas() {
        return codigo_peliculas;
    }

    public void establecer_Codigo_peliculas(String codigo_peliculas) {
        this.codigo_peliculas = codigo_peliculas;
    }

    public String obtener_Director_peliculas() {
        return director_peliculas;
    }

    public void establecer_Director_peliculas(String director_peliculas) {
        this.director_peliculas = director_peliculas;
    }

    public String obtener_Proovedor_peliculas() {
        return proovedor_peliculas;
    }

    public void establecer_Proovedor_peliculas(String proovedor_peliculas) {
        this.proovedor_peliculas = proovedor_peliculas;
    }

    public Integer obtener_Cantidad_pelicula() {
        return cantidad_pelicula;
    }

    public void establecer_Cantidad_pelicula(Integer cantidad_pelicula) {
        this.cantidad_pelicula = cantidad_pelicula;
    }
    public void Agregar_fecha_estreno_peliculas(int año,int mes, int dia){
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes-1, dia);
        this.fecha_estreno_peliculas = calendario.getTime();
    }
    public Date obtener_fecha_estreno_pelicula(){
        return fecha_estreno_peliculas;
    }
    public void establecer_disponibilidad_venta_peliculas(){
        Date hoy = new Date();
        Calendar calendario = Calendar.getInstance();
        fecha_estreno_peliculas = new Date(calendario.getTimeInMillis());
        long diferencia = (hoy.getTime()-fecha_estreno_peliculas.getTime())/milis_por_dia;
        if(diferencia > 60){
            disponibilidad_peliculas = true;
        }else{
            disponibilidad_peliculas = false;
        }
    }
    public boolean obtener_disponibilidad_venta_pelicula(){
        return disponibilidad_peliculas;
    }
    
    
    /*public void establecer_busqueda_pelicula(String nombre){
        if(listado_peliculas.contains(nombre)){
            busqueda_pelicula = true;
        }else{
            busqueda_pelicula = false;
        }
    }
    public boolean obtener_busqueda_peliculas(){
        return busqueda_pelicula;
    }*/


}