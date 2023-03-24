/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



/**
 *
 * @author Cristoffer
 */
public class Tarea {
    Cuadrillas cuadrilla;
    String Tarea, fruta,variedad,TipoRecogida,Fecha;
    int cantidadPales;

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getCantidadPales() {
        return cantidadPales;
    }

    public void setCantidadPales(int cantidadPales) {
        this.cantidadPales = cantidadPales;
    }

    public Tarea(Cuadrillas cuadrilla, String Tarea, String fruta, String variedad, String TipoRecogida, int cantidadPales,String fecha) {
        this.cuadrilla = cuadrilla;
        this.Tarea = Tarea;
        this.fruta = fruta;
        this.variedad = variedad;
        this.TipoRecogida = TipoRecogida;
        this.cantidadPales = cantidadPales;
        this.Fecha=fecha;
    }
    
    
    
    public Tarea(Cuadrillas cuadrilla, String Tarea, String fruta,String variedad,String TipoRecogida) {
        this.cuadrilla = cuadrilla;
        this.Tarea = Tarea;
        this.fruta = fruta;
        this.variedad=variedad;
        this.TipoRecogida=TipoRecogida;
      
    }

    public String getTipoRecogida() {
        return TipoRecogida;
    }

    public void setTipoRecogida(String TipoRecogida) {
        this.TipoRecogida = TipoRecogida;
    }

    public Cuadrillas getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrillas cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public String getTarea() {
        return Tarea;
    }

    public void setTarea(String Tarea) {
        this.Tarea = Tarea;
    }

    public String getFruta() {
        return fruta;
    }

    public void setFruta(String fruta) {
        this.fruta = fruta;
    }

 
    
    
    
    
}
