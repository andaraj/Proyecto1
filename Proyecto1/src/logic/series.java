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
public class series extends Video{
    
    protected String productor;
    
    public series(String codigo, String titulo, String descripcion, String proovedor,String tipo,
        String calificacion,int cantidad, Date fecha_estreno, String productor) {
        super(codigo,titulo,descripcion,proovedor,tipo,calificacion,cantidad,fecha_estreno);
        this.productor = productor;
    }
    
    public series(){
        
    }
        
    public void establecer_Productor(String productor){
        this.productor = productor;
    }
    
    public String obtener_Productor(){
        return this.productor;
    }
    
   
}
