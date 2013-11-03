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
        /*System.out.println("Ingrese usuario que le gustaria tener: ");
        String usuario = sc.next();
        if((usuario_cajero.contains(usuario))){
            System.out.println("El nombre de usuario ya esta ocupado, por favor digite otro: ");
            agregar_nombre_usuario(sc);
        }else{
            usuario_cajero.add(usuario);
        }
        */
    }
    @Override
    public String obtener_nombre_usuario(){
        return usuario;
    }
    @Override
    public void agregar_contraseña(String contraseña){
        this.contraseña = contraseña;
        /*System.out.println("Ingrese una contraseña de mas de 6 digitos: ");
        String password = sc.next();
        if(Integer.parseInt(password)>6){
            contraseña_cajero.add(password);
        }else{
            System.out.println("La contraseña agregada es menor de 6 digitos digite una con mas de 6: ");
            agregar_contraseña(sc);
        }
     */   
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
