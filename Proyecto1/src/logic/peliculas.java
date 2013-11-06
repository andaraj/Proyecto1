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
public class peliculas extends Video{
    
    protected String director;
    
    public peliculas(String codigo, String titulo, String descripcion, String proovedor,String tipo,
        String calificacion,int cantidad, Date fecha_estreno, String director){
        super(codigo,titulo,descripcion,proovedor,tipo,calificacion,cantidad,fecha_estreno);
        this.director = director;
    }
    public peliculas(){
        
    }
        
    public void establecer_Director(String director){
        this.director = director;
    }
    
    public String obtener_Director(){
        return director;
    }
    
    

}