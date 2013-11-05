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
    
    protected static ArrayList <administrador> datos_administrador = new ArrayList<>();
    protected static ArrayList <cajero> datos_cajero = new ArrayList<>();;
    protected static ArrayList <Proveedor> datos_proveedor = new ArrayList<>();
    protected static ArrayList <cliente> datos_cliente = new ArrayList<>();
    protected static ArrayList <Video> datos_video = new ArrayList<>();
    protected static ArrayList <Transaccion> datos_transaccion = new ArrayList<>();
    protected static boolean busqueda_pelicula;
    protected static boolean busqueda_series;
    protected static boolean disponibilidad_peliculas;
    protected static boolean disponibilidad_series;
    protected static boolean busqueda;
    protected static boolean moroso;
    protected static Date now = new Date();
    private static final long milis_por_dia = 86400000;
    public static Video fecha_pelicula = new peliculas();
    public static Video fecha_serie = new series();
    public static Renta fecha = (Renta)new Transaccion();
    
    
    public static void agregar_Datos_Cliente(String nombre, String apellido, String direccion,String usuario,
            String contraseña,String cedula, int celular, String mail) {
         datos_cliente.add(new cliente(nombre,apellido,direccion,usuario,contraseña,cedula,celular,mail));
    }
    
    public static void agregar_Datos_cajero(String nombre, String apellido, String direccion,String usuario,
            String contraseña,String puesto, String turno, int salario){
        datos_cajero.add(new cajero(nombre,apellido,direccion,usuario,contraseña,puesto,turno,salario));
    }
    
    public static void agregar_Datos_Proovedor(String nombre, String apellido, String direccion,String usuario,
            String contraseña , String ID, String cuenta_banco){
        datos_proveedor.add(new Proveedor(nombre,apellido,direccion,usuario,contraseña,ID,cuenta_banco));
    }
    
    public static void agregar_Datos_Administrador(String nombre, String apellido, String direccion,String usuario,
            String contraseña,String puesto, String turno, int salario){
        datos_administrador.add(new administrador(nombre,apellido,direccion,usuario,contraseña,puesto,turno,salario));
    }
    
    public static void agregar_Datos_Peliculas(String codigo, String titulo, String descripcion, String proovedor,
            String tipo,String calificacion,int cantidad, Date fecha_estreno, String director){
        datos_video.add(new peliculas(codigo,titulo,descripcion,proovedor,tipo,calificacion,cantidad,fecha_estreno,director));
    }
    
    public static void agregar_Datos_Series(String codigo, String titulo, String descripcion, String proovedor,
            String tipo,String calificacion,int cantidad, Date fecha_estreno, String productor){
        datos_video.add(new series(codigo,titulo,descripcion,proovedor,tipo,calificacion,cantidad,fecha_estreno,productor));
    }
    
    public static void agregar_Ventas(String nombre_venta, String busqueda_codigo, String usuario,
            String turno,String email, int cantidad_final){
        datos_transaccion.add(new Venta(nombre_venta,busqueda_codigo,usuario,turno,email,cantidad_final));
    }
    
    public static void agregar_Renta(String nombre_renta, String busqueda_codigo, String usuario
            , String turno, String email, int cantidad_final, Date fecha_renta,boolean mora){
        datos_transaccion.add(new Renta(nombre_renta,busqueda_codigo,usuario,turno,email,cantidad_final,fecha_renta,mora));
    }
    public static void establecer_disponibilidad_venta_peliculas(){
        Date hoy = new Date();
        Calendar calendario = Calendar.getInstance();
        fecha_pelicula.fecha_estreno = new Date(calendario.getTimeInMillis());
        long diferencia = (hoy.getTime()-fecha_pelicula.fecha_estreno.getTime())/milis_por_dia;
        if(diferencia > 60){
            disponibilidad_peliculas = true;
        }else{
            disponibilidad_peliculas = false;
        }
    }
    public static boolean obtener_disponibilidad_venta_pelicula(){
        return disponibilidad_peliculas;
    }
    
    public static void establecer_disponibilidad_venta_Series(){
        Date hoy = new Date();
        Calendar calendario = Calendar.getInstance();
        fecha_serie.fecha_estreno = new Date(calendario.getTimeInMillis());
        long diferencia = (hoy.getTime()-fecha_serie.fecha_estreno.getTime())/milis_por_dia;
        if(diferencia > 60){
            disponibilidad_series = true;
        }else{
            disponibilidad_series = false;
        }
    }
    public static boolean obtener_disponibilidad_venta_Series(){
        return disponibilidad_series;
    }
    
    public void establecer_busqueda_pelicula(String codigo, int i){
        if(i < datos_video.size()){
        if(datos_video.get(i).codigo.equals(codigo)){
            busqueda_pelicula = true;
        }else{
            establecer_busqueda_pelicula(codigo,(i+1));
        }
        }else{
            busqueda_pelicula = false;
        }
    }
    
    public boolean obtener_busqueda_peliculas(){
        return busqueda_pelicula;
    }
    
    public void establecer_busqueda_Series(String codigo, int i){
        if(i < datos_video.size()){
        if(datos_video.get(i).codigo.equals(codigo)){
            busqueda_series = true;
        }else{
            establecer_busqueda_Series(codigo,(i+1));
        }
        }else{
            busqueda_series = false;
        }
    }
    
    public boolean obtener_busqueda_Series(){
        return busqueda_series;
    }
    
        public static void establecer_Mora(int i){
            if(i < datos_transaccion.size()){
            if(busqueda_series == true || busqueda_pelicula == true){
                Calendar calendario = Calendar.getInstance();
                fecha.fecha_renta = new Date(calendario.getTimeInMillis());
                long tempo = (now.getTime() - fecha.fecha_renta.getTime())/milis_por_dia;
                if(tempo > 0){
                    establecer_Mora((i+1));
                }else{
                    moroso = true;
                }
            }else{
                System.out.println("No existe pedido");
            }
            }else{
                moroso = false;
            }
    }
    
        public static boolean obtener_mora(){
            return moroso;
        }
    
    public static void Imprimir_Menu_Principal(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Ingresar al sistema ");
        System.out.println("2- Ver reportes ");
        System.out.println("3- Salir del sistema ");
        
    }
    
    public static void Imprimir_Menu_Administrador(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Agregar Empleados");
        System.out.println("2- Agregar Clientes");
        System.out.println("3- Agregar Proveedores");
        System.out.println("4- Compras Realizadas");
        System.out.println("5- Agregar Datos Peliculas");
        System.out.println("6- Agregar Datos Series");
        System.out.println("7- Salir del Sistema");
    }
    
    public static void Imprimir_Menu_Cajero(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Vender");
        System.out.println("2- Rentar");
        System.out.println("3- Salir del Sistema");
    }
    
    public static void Imprimir_Menu_cliente(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Comprar ");
        System.out.println("2- Rentar ");
        System.out.println("3- Lista de peliculas ");
        System.out.println("4- Mas rentadas ");
        System.out.println("5- Compras Recientes");
        System.out.println("6- Alquileres Recientes");
        System.out.println("7- Salir del sistema ");
    }
    
    public static void Imprimir_Menu_Proveedor(){
        System.out.println("**********NETFLIX**********");
        System.out.println("1- Cantidad en Inventario Peliculas/Series");
        System.out.println("2- Buscar Peliculas/Series");
        System.out.println("3- Peliculas/Series Populares");
        System.out.println("4- Ultimas ventas realizadas a Netflix");
        System.out.println("5- Salir del sistema");
    }
    /*   
 public void Compra_Venta(String usuario,String contraseña,String nombre, int pos, int cantidad_a_comprar,String email){
     if(comprador.usuario_cliente.contains(usuario)&&comprador.contraseña_cliente.contains(contraseña)){
         Calendar calendario = Calendar.getInstance();
         //if(comprador.membresia){
         for (int i = 0; i<renta_venta.listado_peliculas.size();i++){
             System.out.println("Las peliculas disponibles son: " + renta_venta.listado_peliculas.get(i));
         }
         if (renta_venta.listado_peliculas.contains(nombre)){
             pos = renta_venta.listado_peliculas.indexOf(nombre);
         }
         if(renta_venta.cantidad_pelicula.get(pos)>0){
             System.out.println("La pelicula a comprar es: " + renta_venta.listado_peliculas.get(pos));
             if(comprador.email.contains(email)){
             venta_peliculas_final = cantidad_a_comprar*renta_venta.precio_venta_peliculas;
             }
         }else{
             System.out.println("Lo sentimos la pelicula no esta disponible");
         }
     //}
     }
 }*/

    /**/
    
     /*public void Agregar_series(String nombre, String comentario){
        if(busqueda == true){
            System.out.println("La Serie ya esta Agregada");
        }else{
            listado_series.add(nombre);
            Agregar_descripcion_series(comentario);
        }
    }*/

    public static void main(String[] args) {
        
    }
}
