/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Jaime Andara
 */
public class Proveedor extends usuario{
    private String ID;
    private String cuenta_banco;

    public Proveedor(String nombre, String apellido, String direccion,String usuario, String contraseña , String ID, String cuenta_banco) {
        super(nombre,apellido,direccion,usuario,contraseña);
        this.ID = ID;
        this.cuenta_banco = cuenta_banco;
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
    public void agregar_ID(String ID){
        this.ID = ID;        
    }
    public String obtener_ID(){
        return ID;
    }
    public void agregar_cuenta_banco(String cuenta){
        this.cuenta_banco = cuenta;
    }
    public String obtener_cuenta_banco(){
        return cuenta_banco;
    }
}
