/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cristoffer
 */
public class Trabajadores {
    public int Cod_Trabajador;
    public int telefono;
    public String nombre,apellidos;
    public int Cuadrilla;
    public boolean Podador;
    public String tipoTrabajador;
    public int tractor;

    public Trabajadores() {
    }

    public Trabajadores(int Cod_Trabajador, String nombre, int Cuadrilla) {
        this.Cod_Trabajador = Cod_Trabajador;
        this.nombre = nombre;
        this.Cuadrilla = Cuadrilla;
    }
    
    

    public Trabajadores(int telefono, String nombre, String apellidos, int Cuadrilla, boolean Podador, String tipoTrabajador) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.Cuadrilla = Cuadrilla;
        this.Podador = Podador;
        this.tipoTrabajador = tipoTrabajador;
    }

    public Trabajadores(int Cod_Trabajador, int telefono, String nombre, String apellidos, int Cuadrilla, boolean Podador, String tipoTrabajador) {
        this.Cod_Trabajador = Cod_Trabajador;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.Cuadrilla = Cuadrilla;
        this.Podador = Podador;
        this.tipoTrabajador = tipoTrabajador;
        //this.tractor = tractor;
    }
   
    
    

    public Trabajadores(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getCod_Trabajador() {
        return Cod_Trabajador;
    }

    public void setCod_Trabajador(int Cod_Trabajador) {
        this.Cod_Trabajador = Cod_Trabajador;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCuadrilla() {
        return Cuadrilla;
    }

    public void setCuadrilla(int Cuadrilla) {
        this.Cuadrilla = Cuadrilla;
    }

    public boolean isPodador() {
        return Podador;
    }

    public void setPodador(boolean Podador) {
        this.Podador = Podador;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public int getTractor() {
        return tractor;
    }

    public void setTractor(int tractor) {
        this.tractor = tractor;
    }
    
    

    

 
  
    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
    
    
    
}

