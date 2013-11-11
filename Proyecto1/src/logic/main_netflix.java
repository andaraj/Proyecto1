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
    public static Transaccion renta = new Renta();
    public static Transaccion venta = new Venta();
    public static usuario transaccion = new cajero();
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
        if(busqueda_pelicula == false)
        datos_video.add(new peliculas(codigo,titulo,descripcion,proovedor,tipo,calificacion,cantidad,fecha_estreno,director));
        else 
            System.out.println("Pelicula ya Ingresada");
    }
    
    public static void agregar_Datos_Series(String codigo, String titulo, String descripcion, String proovedor,
            String tipo,String calificacion,int cantidad, Date fecha_estreno, String productor){
        if(busqueda_series == false)
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
    
    public static Date Agregar_fecha_estreno_peliculas(int año,int mes, int dia){
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes-1, dia);
        fecha_estreno_peliculas = calendario.getTime();
        return fecha_estreno_peliculas;
    }
    
    public static Date agregar_Fecha_Estreno_Series(int año,int mes, int dia){
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes-1, dia);
        fecha_estreno_series = calendario.getTime();
        return fecha_estreno_series;
    }
    
    
    public static void establecer_disponibilidad_venta_peliculas(){
        Date hoy = new Date();
        Calendar calendario = Calendar.getInstance();
        fecha_pelicula.fecha_estreno = new Date(calendario.getTimeInMillis());
        long diferencia = (hoy.getTime()-fecha_pelicula.fecha_estreno.getTime())/milis_por_dia;
        if(diferencia > 90){
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
        if(diferencia > 90){
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
    public static Transaccion establecer_Mas_Rentada(){
        for (int i = 0; i < datos_transaccion.size(); i++) {
            int contador = 1;
            for (int j = i+1; j < datos_transaccion.size(); j++) {
                if(datos_transaccion.get(i).equals(datos_transaccion.get(j))){
                    
                }if(datos_transaccion.get(i) != null){
                    renta = datos_transaccion.get(i);
                }
            }
        }
        return renta;
    }
    
    public static Transaccion establecer_Mas_Comprada(){
        for (int i = 0; i < datos_transaccion.size(); i++) {
            int contador = 1;
            for (int j = i+1; j < datos_transaccion.size(); j++) {
                if(datos_transaccion.get(i).equals(datos_transaccion.get(j))){
                    
                }if(datos_transaccion.get(i) != null){
                    venta = datos_transaccion.get(i);
                }
            }
        }
        return venta;
    }
    
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
        
        agregar_Datos_Cliente("Maria", "Ortega", "Choloma","maria.o@netflix.com",
            "maria.ortega","0501-1991-12582", 98435644, "maria.o@gmail.com",0);
        
        Date estreno = Agregar_fecha_estreno_peliculas(1996,2,16);
        agregar_Datos_Peliculas("PC001","Happy Gilmore","Un jugador de hockey rechazado pone su abilidad sobre un campo de golf para salvar la casa de su abuela","Universal Pictures",
            "Comedia","PG",6,estreno,"Dennis Dugan");
        
        Date estreno1 = Agregar_fecha_estreno_peliculas(2013,7,16);
        agregar_Datos_Peliculas("PA001","Wolverine Inmortal","Vulnerable por primera vez y desafiando sus límites físicos y emocionales, no sólo se enfrenta al letal acero samurái, sino también a una lucha interna contra su propia inmortalidad que le volverá más fuerte de lo que jamás le hemos visto","20th Century Fox",
            "Accion","PG-13",3,estreno1,"James Mangold");
            
        for (int i = 0; i < datos_usuarios.size(); i++) {
            if(datos_usuarios.get(i) instanceof administrador){
                System.out.println("Nombre admin: " + datos_usuarios.get(i).nombre +" "+ "Apellido Admin: " + datos_usuarios.get(i).apellido);
            }
            
        }
        
        while(opcionelegida != 3){
            
            Imprimir.Menu_Principal();
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
                           Imprimir.Menu_Administrador();
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
                                   for (Video imprimir : datos_video) {
                                       System.out.println("Compras realizadas: " + imprimir.codigo + " " + imprimir.titulo
                                               + " " + imprimir.proovedor);
                                   }
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
                                   System.out.println("Ingrese codigo Serie: ");
                                   String codigo_serie = sc.next();
                                   System.out.println("Ingrese Titulo de Serie: ");
                                   String titulo_serie = sc.next();
                                   System.out.println("Director de la Serie: ");
                                   String productor_serie = sc.next();
                                   System.out.println("Ingrese Descripcion de Serie: ");
                                   String descripcion_serie = sc.next();
                                   System.out.println("Ingrese Proveedor de Serie: ");
                                   String proveedor_serie = sc.next();
                                   System.out.println("Ingrese Calificacion de Serie: ");
                                   String calificacion_serie = sc.next();
                                   System.out.println("Ingrese cantidad en existencia de Serie: ");
                                   int cantidad_serie = sc.nextInt();
                                   System.out.println("Agregar año de fecha estreno: ");
                                   int año_serie = sc.nextInt();
                                   System.out.println("Ingrese mes de fecha de Estreno: ");
                                   int mes_serie = sc.nextInt();
                                   System.out.println("Ingrese Dia de fecha de Estreno: ");
                                   int dia_serie = sc.nextInt();
                                   agregar_Fecha_Estreno_Series(año_serie,mes_serie,dia_serie);
                                   
                                  agregar_Datos_Series(codigo_serie,titulo_serie,descripcion_serie,proveedor_serie,
                                   "Series",calificacion_serie,cantidad_serie,fecha_estreno_series,productor_serie);
                                   break;
                               case 7:
                                   System.out.println("SALIENDO......");
                                   break;
                               default:
                                   break;
                          } 
                       }
                       }
                       else if (datos_usuarios.get(i) instanceof cajero){
                           Imprimir.Menu_Cajero();
                           int opcionarealizar = sc.nextInt();
                           while(opcionarealizar !=3){
                           switch(opcionarealizar){
                               case 1:
                                   System.out.println("Ingrese Nombre de Video: ");
                                   String nombre_venta = sc.next();
                                   System.out.println("Ingrese Codigo de Video: ");
                                   String codigo_venta = sc.next();
                                   System.out.println("Ingrese E-mail del cliente: ");
                                   String email_cliente = sc.next();
                                   System.out.println("Ingrese cantidad a vender: ");
                                   int cantidad_venta = sc.nextInt();
                                   if(disponibilidad_peliculas == true){
                                       int indexof = datos_video.indexOf(codigo_venta);
                                       int cantidad = datos_video.get(indexof).cantidad;
                                   if(cantidad_venta < cantidad){    
                                   agregar_Ventas(nombre_venta,codigo_venta,datos_usuarios.get(i).usuario,
                                    ((cajero)transaccion).turno,email_cliente,cantidad_venta);
                                   }else
                                           System.out.println("Cantidad Insuficiente para realizar transaccion");
                                   }else
                                       System.out.println("El video no esta disponible para su venta");
                                   break;
                               case 2:
                                   System.out.println("Ingrese Nombre de Video: ");
                                   String nombre_renta = sc.next();
                                   System.out.println("Ingrese Codigo de Video: ");
                                   String codigo_renta = sc.next();
                                   System.out.println("Ingrese E-mail del cliente: ");
                                   String mail_cliente = sc.next();
                                   System.out.println("Ingrese cantidad a Rentar: ");
                                   int cantidad_renta = sc.nextInt();
                                   Date fecha_renta = new Date();
                                   int index = datos_video.indexOf(codigo_renta);
                                   int cantidadtotal = datos_video.get(index).cantidad;
                                   if(cantidad_renta < cantidadtotal){
                                   agregar_Renta(nombre_renta,codigo_renta,datos_usuarios.get(i).usuario
                                    ,((cajero)transaccion).turno,mail_cliente,cantidad_renta,fecha_renta,true);
                                   }else
                                       System.out.println("Cantidad insufieciente para la renta");
                                   break;
                               case 3:
                                   System.out.println("Saliendo...");
                                   break;
                               default:
                                   break;
                           }
                         }
                       }
                       else if(datos_usuarios.get(i) instanceof cliente){
                           Imprimir.Menu_cliente();
                           int opcioncasecliente = sc.nextInt();
                           while(opcioncasecliente !=7){
                           switch(opcioncasecliente){
                               case 1:
                                   System.out.println("Ingrese Nombre de Video: ");
                                   String nombre_venta = sc.next();
                                   System.out.println("Ingrese Codigo de Video: ");
                                   String codigo_venta = sc.next();
                                   System.out.println("Ingrese cantidad a Comprar: ");
                                   int cantidad_compra = sc.nextInt();
                                   if(disponibilidad_peliculas == true){
                                       int indexof = datos_video.indexOf(codigo_venta);
                                       int cantidad = datos_video.get(indexof).cantidad;
                                   if(cantidad_compra < cantidad){    
                                   agregar_Ventas(nombre_venta,codigo_venta,datos_usuarios.get(i).usuario,
                                   "",((cliente)transaccion).email,cantidad_compra);
                                   }else
                                           System.out.println("¡CANTIDAD INSUFICIENTE PARA SU COMPRA!");
                                   }else
                                       System.out.println("¡VIDEO NO DISPONIBLE PARA SU COMPRA!");
                                           
                                   break;
                               case 2:
                                   System.out.println("Ingrese Nombre de Video: ");
                                   String nombre_renta = sc.next();
                                   System.out.println("Ingrese Codigo de Video: ");
                                   String codigo_renta = sc.next();
                                   System.out.println("Ingrese cantidad a Rentar: ");
                                   int cantidad_renta = sc.nextInt();
                                   Date fecha_renta = new Date();
                                   int index = datos_video.indexOf(codigo_renta);
                                   int cantidadtotal = datos_video.get(index).cantidad;
                                   if(cantidad_renta < cantidadtotal){
                                   agregar_Renta(nombre_renta,codigo_renta,datos_usuarios.get(i).usuario
                                    ,"",((cliente)transaccion).email,cantidad_renta,fecha_renta,true);
                                   }else
                                       System.out.println("CANTIDAD INSUFICIENTE PARA SU RENTA");
                                   break;
                               case 3:
                                   System.out.println("Ingresar codigo de Video: ");
                                   String codigo_busqueda = sc.next();
                                   int datoaeliminar = datos_transaccion.indexOf(codigo_busqueda);
                                   if(datos_transaccion.get(i).busqueda_codigo.equals(codigo_busqueda)){
                                       datos_transaccion.remove(datoaeliminar);
                                   }else{
                                       System.out.println("La transaccion no existe");
                                   }
                                   break;
                               case 4:
                                   for(Video lista : datos_video)
                                       System.out.println("Listado de disponibles" + " " + lista.codigo + " " + lista.titulo +
                                               " "+lista.descripcion + lista.cantidad);
                                   break;
                               case 5:
                                   System.out.println(renta);
                                   break;
                               case 6:
                                   System.out.println("Ingrese usuario: ");
                                   String usuario_cli = sc.next();
                                   for (int j = 0; j < datos_transaccion.size(); j++) {
                                   if(datos_transaccion.get(j).usuario.equals(usuario_cli)){
                                       System.out.println(datos_transaccion.get(j).nombre_venta_renta);
                                   }else
                                           System.out.println("El usuario no ha realizado ninguna transaccion");
                                   }
                                   break;
                               case 7:
                                   break;
                               default:
                                   break;
                           }
                         }
                       }else if(datos_usuarios.get(i) instanceof Proveedor){
                           Imprimir.Menu_Proveedor();
                           int opcion_proveedor = sc.nextInt();
                           while(opcion_proveedor !=5 ){
                               switch(opcion_proveedor){
                                   case 1:
                                       System.out.println("Ingrese proveedor: ");
                                       String proveedor = sc.next();
                                       for (int j = 0; j < datos_video.size(); j++) {
                                       if(datos_video.get(j).proovedor.equals(proveedor)){
                                           System.out.println(datos_video.get(j).cantidad); 
                                       }else{
                                           System.out.println("El Proveedor no existe");
                                       }    
                                       }
                                       break;
                                   case 2:
                                       for (int j = 0; j < datos_video.size(); j++) {
                                       System.out.println(datos_video.get(j).titulo + " " + datos_video.get(j).descripcion);    
                                       }
                                       break;
                                   case 3:
                                       for (int j = 0; j < datos_transaccion.size(); j++) {
                                           System.out.println("Mas vendida: " + " " + venta);
                                           System.out.println("Mas Rentada: " + " " + renta);
                                       }
                                       break;
                                   case 4:
                                       System.out.println("Ingrese proveedor: ");
                                       String provee = sc.next();
                                       for (int j = 0; j < 10; j++) {
                                       if(datos_video.get(j).proovedor.equals(provee)){
                                           System.out.println(datos_video.get(j).titulo + " " + datos_video.get(j).cantidad); 
                                       }else{
                                           System.out.println("El Proveedor no existe");
                                       }    
                                       }
                                       break;
                                   case 5:
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
                    for(Video imprimir:datos_video)
                        System.out.println(imprimir);
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