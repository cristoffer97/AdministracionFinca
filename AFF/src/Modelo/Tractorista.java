/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cristoffer
 */
public class Tractorista extends Trabajadores{
private Tractor tractor;
private int Cod_Tractor;
    public Tractorista() {
    }

    public Tractorista(int Cod_Trabajador, String nombre, int Cuadrilla) {
        super(Cod_Trabajador, nombre, Cuadrilla);
    }



    public Tractorista(int Cod_Tractor, int Cod_Trabajador, int telefono, String nombre, String apellidos, int Cuadrilla, boolean Podador, String tipoTrabajador) {
        super(Cod_Trabajador, telefono, nombre, apellidos, Cuadrilla, Podador, tipoTrabajador);
        this.Cod_Tractor = Cod_Tractor;
    }

    public Tractorista(Tractor tractor, int Cod_Tractor, int Cod_Trabajador, int telefono, String nombre, String apellidos, int Cuadrilla, boolean Podador, String tipoTrabajador) {
        super(Cod_Trabajador, telefono, nombre, apellidos, Cuadrilla, Podador, tipoTrabajador);
        this.tractor = tractor;
        this.Cod_Tractor = Cod_Tractor;
    }

  

    
    
 
  

    public int getCod_Tractor() {
        return Cod_Tractor;
    }

    public void setCod_Tractor(int Cod_Tractor) {
        this.Cod_Tractor = Cod_Tractor;
    }
    

    /*public Tractorista(Tractor tractor, int Cod_Trabajador, int telefono, String nombre, String apellidos, int Cuadrilla, boolean Tractorista, boolean Manijero, boolean Encargado, boolean Podador) {
        super(Cod_Trabajador, telefono, nombre, apellidos, Cuadrilla, Tractorista, Manijero, Encargado, Podador);
        this.tractor = tractor;
    }
    

    public Tractorista(int Cod_Trabajador, int telefono, String nombre, String apellidos, int Cuadrilla, boolean Tractorista, boolean Manijero, boolean Encargado, boolean Podador) {
        super(Cod_Trabajador, telefono, nombre, apellidos, Cuadrilla, Tractorista, Manijero, Encargado, Podador);
    }*/

    public Tractorista(String nombre, String apellidos) {
        super(nombre, apellidos);
    }
    
    public String obtenerdatos(){
        String cadena="Codigo:"+Cod_Trabajador+"/ "+nombre;
        return cadena;
    }


    
    
    
}
