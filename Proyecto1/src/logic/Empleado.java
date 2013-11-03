/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Jaime Andara
 */
public abstract class Empleado extends usuario{
    protected String puesto;
    protected int salario;
    protected String turno;
    

    public Empleado(String nombre, String apellido, String direccion,String usuario, String contraseña,String puesto, String turno, int salario) {
        super(nombre,apellido,direccion,usuario,contraseña);
        this.puesto = puesto;
        this.salario = salario;
        this.turno = turno;
        
    }
    public Empleado(){
        
    }
    public abstract String puesto();
        
    public abstract int salario();
    
    public abstract void establecer_turno(String turno);
    
    public abstract String turno();
    
    
}
