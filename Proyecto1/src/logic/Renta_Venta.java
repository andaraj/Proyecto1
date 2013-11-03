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
public abstract class Renta_Venta extends usuario{
    protected String usuario_cliente;
    protected String contraseña_clente;
    protected String usuario_cajero;
    protected String contraseña_cajero;
    protected double venta_peliculas_final;
    peliculas renta_venta = new peliculas();
    series venta_renta = new series();

    
    public Renta_Venta(){
        
    }
 /*   
 public void establecer_venta(String usuario,String contraseña,String nombre, int pos, int cantidad_a_comprar,String email){
     if(comprador.usuario_cliente.contains(usuario)&&comprador.contraseña_cliente.contains(contraseña)){
         Calendar calendario = Calendar.getInstance();
         //if(comprador.membresia){
         for (int i = 0; i<renta_venta.listado_peliculas.size();i++){
             System.out.println("Las peliculas disponibles son: " + renta_venta.listado_peliculas.get(i));
         }
         if (renta_venta.listado_peliculas.contains(nombre)){
             pos = renta_venta.listado_peliculas.indexOf(nombre);
         }
         if(renta_venta.cantidad_pelicula.get(pos)>0){
             System.out.println("La pelicula a comprar es: " + renta_venta.listado_peliculas.get(pos));
             if(comprador.email.contains(email)){
             venta_peliculas_final = cantidad_a_comprar*renta_venta.precio_venta_peliculas;
             }
         }else{
             System.out.println("Lo sentimos la pelicula no esta disponible");
         }
     //}
     }
 }*/
    public void establecer_renta(){
 
    }
}
