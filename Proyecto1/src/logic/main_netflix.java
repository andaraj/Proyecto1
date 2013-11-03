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
public class main_netflix {
    protected static ArrayList<cajero> datos_cajero = new ArrayList<>();;
    protected static ArrayList<proovedor> datos_proovedor = new ArrayList<>();
    protected static ArrayList<cliente> datos_cliente = new ArrayList<>();
    protected static ArrayList <peliculas> datos_peliculas = new ArrayList<>();
    protected static ArrayList <series> datos_series = new ArrayList<>();
    
    
    public static void agregar_Datos_Cliente(String nombre, String apellido, String direccion,String usuario, String contraseña,String cedula, int celular, String mail) {
         datos_cliente.add(new cliente(nombre,apellido,direccion,usuario,contraseña,cedula,celular,mail));
    }
   /* public static void agregar_cajeros(String nombre, String apellido, String direccion,
            String usuario, String contraseña,String puesto, String turno, int salario){
        agregar_datos.datos_cajero.add(new cajero(nombre,apellido,direccion,usuario,contraseña,puesto,turno,salario));
    }
    public static void Imprimir(){
        for (int i = 0; i < agregar_datos.datos_cajero.size(); i++) {
            System.out.println("Datos Cajero: ");
            System.out.println("Nombre: "+ agregar_datos.datos_cajero.get(i).nombre 
                    + "Apellido: " + agregar_datos.datos_cajero.get(i).apellido);
            
        }
    }*/
    
    public static void main(String[] args) {
        
    }
}
