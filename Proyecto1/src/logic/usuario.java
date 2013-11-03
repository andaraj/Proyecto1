/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
/**
 *
 * @author Jaime Andara
 */
public abstract class usuario {
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contraseña;
    protected String direccion;

   
    public usuario(String nombre, String apellido, String direccion,String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.direccion = direccion;
    }

    
    public usuario() {
        }
    
    public abstract void agregar_nombre_usuario(String usuario);
    
    public abstract String obtener_nombre_usuario ();
    
    public abstract void agregar_contraseña(String contraseña);
    
    public abstract String obtener_contraseña();
    
}