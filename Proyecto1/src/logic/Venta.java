/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Jaime Andara
 */
public class Venta extends Transaccion{
    
    protected final double precio_venta_peliculas = 20;
    private double precio_venta_series = 15;
    protected double venta_final_peliculas;
    protected double venta_final_series;
    
    public Venta(String nombre_venta, String busqueda_codigo, String usuario, String turno,
            String email, int cantidad_final) {
        super(nombre_venta, busqueda_codigo,usuario,turno,email,cantidad_final);
        
    }
    public Venta(){
        
    }
    
    public double pagar_Venta_Final_Peliculas(int cantidad ) {
        this.venta_final_peliculas = (cantidad*precio_venta_peliculas);
        return this.venta_final_peliculas;
    }
    
    public double pagar_Venta_Final_Serie(int cantidad){
        this.venta_final_series = (cantidad * precio_venta_series);
        return this.venta_final_series;
    }
}
