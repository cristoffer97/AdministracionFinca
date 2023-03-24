/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author mescr
 */
public class Informes {
    
    private String Asunto,descripcion,codigo,id_Fruta;

    public Informes(String Asunto, String descripcion, String codigo, String id_Fruta) {
        this.Asunto = Asunto;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.id_Fruta = id_Fruta;
    }

    public Informes() {
    }
    
    

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getId_Fruta() {
        return id_Fruta;
    }

    public void setId_Fruta(String id_Fruta) {
        this.id_Fruta = id_Fruta;
    }
    

  
    
    
    

    @Override
    public String toString() {
        return Asunto +descripcion + codigo + id_Fruta;
    }
    
    
    


       
    
    
    
    
}
