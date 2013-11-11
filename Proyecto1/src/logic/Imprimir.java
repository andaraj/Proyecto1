/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Jaime Andara
 */
public class Imprimir {
 
    public static void Menu_Principal(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Ingresar al sistema ");
        System.out.println("2- Ver reportes ");
        System.out.println("3- Salir del sistema ");
        
    }
    
    public static void Menu_Administrador(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Agregar Empleados");
        System.out.println("2- Agregar Clientes");
        System.out.println("3- Agregar Proveedores");
        System.out.println("4- Compras Realizadas");
        System.out.println("5- Agregar Datos Peliculas");
        System.out.println("6- Agregar Datos Series");
        System.out.println("7- Salir del Sistema");
    }
    
    public static void Menu_Cajero(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Vender");
        System.out.println("2- Rentar");
        System.out.println("3- Salir del Sistema");
    }
    
    public static void Menu_cliente(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Comprar ");
        System.out.println("2- Rentar ");
        System.out.println("3- Cancelar Transaccion ");
        System.out.println("4- Lista de Videos ");
        System.out.println("5- Mas rentadas ");
        System.out.println("6- Transacciones Recientes");
        System.out.println("7- Salir del sistema ");
    }
    
    public static void Menu_Proveedor(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Cantidad en Inventario Peliculas/Series");
        System.out.println("2- Buscar Peliculas/Series");
        System.out.println("3- Peliculas/Series Populares");
        System.out.println("4- Ultimas ventas realizadas a Netflix");
        System.out.println("5- Salir del sistema");
    }
}
