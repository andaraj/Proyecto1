/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
/**
 *
 * @author Jaime Andara
 */
public class cajero extends Empleado{
   
    public cajero(String nombre, String apellido, String direccion,String usuario, String contraseña,String puesto, String turno, int salario) {
        super(nombre,apellido,direccion,usuario,contraseña,puesto,turno,salario);
        
            }
    public cajero(){
        
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
    @Override
    public String puesto(){
        puesto ="Cajero";
        return puesto;
    }
    @Override
    public void establecer_turno(String turno){
        this.turno = turno;
    }
    @Override 
    public String turno(){
        return turno;
    }
    @Override
    public int salario(){
        salario = 2000;
        return salario;
    }
    
}
