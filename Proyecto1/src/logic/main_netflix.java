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
    
    protected static ArrayList <usuario> datos_usuarios = new ArrayList<>();
    protected static ArrayList <Video> datos_video = new ArrayList<>();
    protected static ArrayList <Transaccion> datos_transaccion = new ArrayList<>();
    protected static boolean busqueda_pelicula;
    protected static boolean busqueda_series;
    protected static boolean disponibilidad_peliculas;
    protected static boolean disponibilidad_series;
    protected static boolean busqueda_usuario;
    protected static boolean moroso;
    protected static Date now = new Date();
    protected static Date fecha_estreno_peliculas;
    public static Date fecha_estreno_series;
    private static final long milis_por_dia = 86400000;
    public static Video fecha_pelicula = new peliculas();
    public static Video fecha_serie = new series();
    public static Renta fecha = new Renta();
    static Scanner sc = new Scanner(System.in);
    
    
    public static void agregar_Datos_Cliente(String nombre, String apellido, String direccion,String usuario,
            String contraseña,String cedula, int celular, String mail, int i) {
        if(establecer_Disponibilidad_Usuario(usuario,i)== false){
         datos_usuarios.add(new cliente(nombre,apellido,direccion,usuario,contraseña,cedula,celular,mail));   
        }else{
            System.out.println("¡EL USUARIO NO ESTA DISPONIBLE!");
        }
    }
    
    public static void agregar_Datos_cajero(String nombre, String apellido, String direccion,String usuario,
            String contraseña,String puesto, String turno, int salario, int i){
        if(establecer_Disponibilidad_Usuario(usuario,i)== false){
        datos_usuarios.add(new cajero(nombre,apellido,direccion,usuario,contraseña,puesto,turno,salario));    
        }else{
        System.out.println("¡EL USUARIO NO ESTA DISPONIBLE!");
    }
}
    public static void agregar_Datos_Proovedor(String nombre, String apellido, String direccion,String usuario,
            String contraseña , String ID, String cuenta_banco, int i){
        if(establecer_Disponibilidad_Usuario(usuario,i)== false){
        datos_usuarios.add(new Proveedor(nombre,apellido,direccion,usuario,contraseña,ID,cuenta_banco));    
        }else{
            System.out.println("¡EL USUARIO NO ESTA DISPONIBLE!");
        }
    }
    
    public static void agregar_Datos_Administrador(String nombre, String apellido, String direccion,String usuario,
            String contraseña,String puesto, String turno, int salario, int i){
        if(establecer_Disponibilidad_Usuario(usuario,i)== false){
        datos_usuarios.add(new administrador(nombre,apellido,direccion,usuario,contraseña,puesto,turno,salario));    
        }else{
            System.out.println("¡EL USUARIO NO ESTA DISPONIBLE!");
        }
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
    
    public static boolean establecer_Disponibilidad_Usuario(String usuario, int i){
        if(i < datos_usuarios.size()){
            if(datos_usuarios.get(i).usuario.equals(usuario)){
                busqueda_usuario = true;
            }else{
                establecer_Disponibilidad_Usuario(usuario,(i+1));
            }
        }else{
            busqueda_usuario = false;
        }
        return busqueda_usuario;
    }
    
    public static void Agregar_fecha_estreno_peliculas(int año,int mes, int dia){
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes-1, dia);
        fecha_estreno_peliculas = calendario.getTime();
    }
    public Date obtener_Fecha_Estreno_Peliculas(){
        return fecha_estreno_peliculas;
    }
    
    public static void agregar_Fecha_Estreno_Series(int año,int mes, int dia){
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes-1, dia);
        fecha_estreno_series = calendario.getTime();
    }
    public Date obtener_Fecha_Estreno_Series(){
        return fecha_estreno_series;
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
    
    public static boolean buscar_Usuario(String usuario, String contraseña, int i){
        if(datos_usuarios.get(i).usuario.equals(usuario)&&datos_usuarios.get(i).contraseña.equals(contraseña)){
            return true;
        }else
            return false;
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
    

    public static void main(String[] args) {
        int opcionelegida = 0;
        
        agregar_Datos_Administrador("Jaime", "Andara", "Aurora","andaraj@netflix.com",
            "andara_net","Administrador", "Nocturno", 15000,0);
    
        agregar_Datos_Administrador("Homero", "Simpsons", "Springfield","homer@netflix.com",
            "marge_lisa","Administrador", "Vespertino", 15000,0);
        
        agregar_Datos_Administrador("Trolencio", "Martinez", "Rio Priedras","trollen@netflix.com",
            "cuanto_cabron","Administrador", "Matutino", 15000,0);
       
        agregar_Datos_Cliente("Ana", "Lagos", "La trejo","ana_lagos@netflix.com",
            "2547_mbj","0501-1983-15882", 32331551, "ana_lagos@gmail.com",0);
        
        agregar_Datos_Cliente("Ana", "Lagos", "La trejo","ana_lagos@netflix.com",
            "2547_mbj","0501-1983-15882", 32331551, "ana_lagos@gmail.com",0);
            
            
        for (int i = 0; i < datos_usuarios.size(); i++) {
            if(datos_usuarios.get(i) instanceof administrador){
                System.out.println("Nombre admin: " + datos_usuarios.get(i).nombre +" "+ "Apellido Admin: " + datos_usuarios.get(i).apellido);
            }
            
        }
        
        while(opcionelegida != 3){
            
            Imprimir_Menu_Principal();
            opcionelegida = sc.nextInt();
            switch (opcionelegida){
                case 1:
                    System.out.println("Ingresar usuario: ");
                    String usuario = sc.next();
                    System.out.println("Ingresar contraseña: ");
                    String contraseña = sc.next();
                    for (int i = 0; i < datos_usuarios.size(); i++) {
                        if (buscar_Usuario(usuario,contraseña, 0) == true){
                       if(datos_usuarios.get(i) instanceof administrador){
                           Imprimir_Menu_Administrador();
                           int tarea_a_realizar = sc.nextInt();
                           while(tarea_a_realizar!=7){
                           switch(tarea_a_realizar){
                               case 1:
                                   System.out.println("Ingrese Nombre del Empleado: ");
                                   String nombre_empleado = sc.next();
                                   System.out.println("Ingrese Apellido del Empleado: ");
                                   String apellido_empleado = sc.next();
                                   System.out.println("Ingrese Direccion del Empleado: ");
                                   String direccion_empleado = sc.next();
                                   System.out.println("Ingrese Usuario del Empleado: ");
                                   String usuario_empleado = sc.next();
                                   System.out.println("Ingrese Contraseña del Empleado: ");
                                   String contraseña_empleado = sc.next();
                                   System.out.println("Ingrese Puesto de Empleado: ");
                                   String puesto = sc.next();
                                   System.out.println("Ingrese Turno del Empleado: ");
                                   String turno = sc.next();
                                   System.out.println("Ingrese Salario del Empleado: ");
                                   int salario = sc.nextInt();
                                   agregar_Datos_cajero(nombre_empleado,apellido_empleado,direccion_empleado,
                                           usuario_empleado,contraseña_empleado,puesto,turno,salario,0);
                                   break;
                               case 2:
                                   System.out.println("Ingrese Nombre del cliente: ");
                                   String nombre = sc.next();
                                   System.out.println("Ingrese Apellido del cliente: ");
                                   String apellido = sc.next();
                                   System.out.println("Ingrese Direccion del cliente: ");
                                   String direccion = sc.next();
                                   System.out.println("Ingrese Usuario del cliente: ");
                                   String nombre_usuario_cliente = sc.next();
                                   System.out.println("Ingrese Contraseña del cliente: ");
                                   String password = sc.next();
                                   System.out.println("Ingrese cedula de cliente: ");
                                   String cedula = sc.next();
                                   System.out.println("Ingrese Numero Telefonico del Cliente: ");
                                   int celular = sc.nextInt();
                                   System.out.println("Ingrese E-Mail del cliente: ");
                                   String email_cliente = sc.next();
                                   agregar_Datos_Cliente(nombre,apellido,direccion,nombre_usuario_cliente,
                                    contraseña,cedula,celular,email_cliente,0);
                                   break;
                               case 3:
                                   System.out.println("Ingrese Nombre del Proveedor: ");
                                   String nombre_proveedor = sc.next();
                                   System.out.println("Ingrese Direccion del Proveedor: ");
                                   String direccion_proveedor = sc.next();
                                   System.out.println("Ingrese Usuario del Proveedor: ");
                                   String usuario_proveedor = sc.next();
                                   System.out.println("Ingrese Contraseña del Proveedor: ");
                                   String contraseña_proveedor = sc.next();
                                   System.out.println("Ingrese Puesto de Proveedor: ");
                                   String ID = sc.next();
                                   System.out.println("Ingrese Turno del Proveedor: ");
                                   String cuenta_banco = sc.next();
                                   agregar_Datos_Proovedor(nombre_proveedor,"",direccion_proveedor,usuario_proveedor,
                                    contraseña_proveedor,ID,cuenta_banco,0);
                                   break;
                               case 4:
                                   break;
                               case 5:
                                   System.out.println("Ingrese codigo pelicula: ");
                                   String codigo_pelicula = sc.next();
                                   System.out.println("Ingrese Titulo de Pelicula: ");
                                   String titulo_pelicula = sc.next();
                                   System.out.println("Director de la pelicula: ");
                                   String director_pelicula = sc.next();
                                   System.out.println("Ingrese Descripcion de pelicula: ");
                                   String descripcion_pelicula = sc.next();
                                   System.out.println("Ingrese Proveedor de pelicula: ");
                                   String proveedor_pelicula = sc.next();
                                   System.out.println("Ingrese Calificacion de pelicula: ");
                                   String calificacion_pelicula = sc.next();
                                   System.out.println("Ingrese cantidad en existencia de pelicula: ");
                                   int cantidad_pelicula = sc.nextInt();
                                   System.out.println("Agregar año de fecha estreno: ");
                                   int año_pelicula = sc.nextInt();
                                   System.out.println("Ingrese mes de fecha de Estreno: ");
                                   int mes_pelicula = sc.nextInt();
                                   System.out.println("Ingrese Dia de fecha de Estreno: ");
                                   int dia_pelicula = sc.nextInt();
                                   
                                   Agregar_fecha_estreno_peliculas(año_pelicula,mes_pelicula,dia_pelicula);
                                   agregar_Datos_Peliculas(codigo_pelicula,titulo_pelicula,descripcion_pelicula,proveedor_pelicula,
            "Pelicula",calificacion_pelicula,cantidad_pelicula,fecha_estreno_peliculas,director_pelicula);
                                   break;
                               case 6:
                                  // agregar_Datos_Series(codigo_series,titulo_series,descripcion_series,proveedor_series,
           //                        "Series",calificacion_series,cantidad_series,fecha_estreno_series,productor_series);
                                   break;
                               case 7:
                                   break;
                               default:
                                   break;
                          } 
                       }
                       }
                    }else{
                        System.out.println("¡EL USUARIO NO EXISTE!");
                    }
                    }
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Vuelva Pronto");
                    break;
                default:
                    break;
            
        }
        
    }
}
}