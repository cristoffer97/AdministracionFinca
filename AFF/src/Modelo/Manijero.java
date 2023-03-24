/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cristoffer
 */
public class Manijero extends Trabajadores{

  public Manijero() {
    }

    public Manijero(int Cod_Trabajador, int telefono, String nombre, String apellidos, int Cuadrilla, boolean Podador, String tipoTrabajador) {
        super(Cod_Trabajador, telefono, nombre, apellidos, Cuadrilla, Podador, tipoTrabajador);
    }

 

    public Manijero(String nombre, String apellidos) {
        super(nombre, apellidos);
    }
    
    

     @Override
    public String toString() {
        return nombre +""+  apellidos;
    }


    
    
}
