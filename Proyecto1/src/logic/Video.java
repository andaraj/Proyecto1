/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Date;

/**
 *
 * @author Jaime Andara
 */
public class Video {
protected String codigo;
    protected String titulo;
    protected String descripcion;
    protected String proovedor;
    protected String tipo;
    protected String calificacion;
    protected int cantidad;
    protected Date fecha_estreno;

    public Video(String codigo, String titulo, String descripcion, String proovedor, String tipo, String calificacion, int cantidad, Date fecha_estreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.proovedor = proovedor;
        this.tipo = tipo;
        this.calificacion = calificacion;
        this.cantidad = cantidad;
        this.fecha_estreno = fecha_estreno;
    }
    
    public Video(){
        
    }
    
        public String obtener_Codigo() {
        return codigo;
    }

    public void establecer_Codigo(String codigo) {
        this.codigo = codigo;
    }

    public String obtener_Titulo() {
        return titulo;
    }

    public void establecer_Titulo(String titulo) {
        this.titulo = titulo;
    }

    public String obtener_Descripcion() {
        return descripcion;
    }

    public void establecer_Descripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String obtener_Proovedor() {
        return proovedor;
    }

    public void establecer_Proovedor(String proovedor) {
        this.proovedor = proovedor;
    }

    public String obtener_Tipo() {
        return tipo;
    }

    public void establecer_Tipo(String tipo) {
        this.tipo = tipo;
    }

    public String obtener_Calificacion() {
        return calificacion;
    }

    public void establecer_Calificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public int obtener_Cantidad() {
        return cantidad;
    }

    public void establecer_Cantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date obtener_Fecha_estreno() {
        return fecha_estreno;
    }

    public void establecer_Fecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

}
