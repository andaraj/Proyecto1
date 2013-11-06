/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Jaime Andara
 */
public class Transaccion {
    protected String nombre_venta_renta;
    protected String busqueda_codigo;
    protected String usuario;
    protected String turno;
    protected String email;
    protected int cantidad_final;
    

    public Transaccion(String nombre_venta_renta, String busqueda_codigo, String usuario, String turno, 
            String email, int cantidad_final) {
        this.nombre_venta_renta = nombre_venta_renta;
        this.busqueda_codigo = busqueda_codigo;
        this.usuario = usuario;
        this.turno = turno;
        this.email = email;
        this.cantidad_final = cantidad_final;
        
    }

    public Transaccion() {
    }
    
    public String obtener_Nombre_venta_renta() {
        return nombre_venta_renta;
    }

    public void establecer_Nombre_venta_renta(String nombre_venta_renta) {
        this.nombre_venta_renta = nombre_venta_renta;
    }

    public String obtener_Busqueda_codigo() {
        return busqueda_codigo;
    }

    public void establecer_Busqueda_codigo(String busqueda_codigo) {
        this.busqueda_codigo = busqueda_codigo;
    }

    public String obtener_Usuario() {
        return usuario;
    }

    public void establecer_Usuario(String usuario) {
        this.usuario = usuario;
    }

    public String obtener_Turno() {
        return turno;
    }

    public void establecer_Turno(String turno) {
        this.turno = turno;
    }

    public String obtener_Email() {
        return email;
    }

    public void establecer_Email(String email) {
        this.email = email;
    }

    public int obtener_Cantidad_final() {
        return cantidad_final;
    }

    public void establecer_Cantidad_final(int cantidad_final) {
        this.cantidad_final = cantidad_final;
    }    
}