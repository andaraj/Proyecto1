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
public class cliente extends usuario{
    protected String cedula;
    protected String email;
    protected int celular;
    protected Date membresia;
    
    public cliente(String nombre, String apellido, String direccion,String usuario, String contraseña,String cedula, int celular, String mail) {
        super(nombre,apellido,direccion,usuario,contraseña);
        this.cedula = cedula;
        this.celular = celular;
        this.email = mail;
        }
    public cliente(){
        
    }
    @Override
    public void agregar_nombre_usuario(String usuario){
        this.usuario = usuario;
    }
    @Override
    public String obtener_nombre_usuario(){
        return usuario;
    }
    @Override
    public void agregar_contraseña(String contraseña){
        this.contraseña = contraseña;
    }
    @Override
    public String obtener_contraseña(){
        return contraseña;
    }

    public void establecer_Cedula(String cedula) {
        this.cedula = cedula;
    }

    public void establecer_Email(String email) {
        /*System.out.println("Ingrese E-mail: ");
        String mail = sc.next();
        if(this.email.contains(mail)){
            System.out.println("El email ya esta ocupado ingreselo nuevamente");
            establecer_Email(sc);
        }else
            this.email.add(mail);
        */
    }

    public void establecer_Celular(int celular) {
        this.celular = celular;
    }

    public void establecer_Membresia(Date membresia) {
        
    }
    
    public String obtener_Cedula() {
        return cedula;
    }

    public int obtener_Celular() {
        return celular;
    }
}
