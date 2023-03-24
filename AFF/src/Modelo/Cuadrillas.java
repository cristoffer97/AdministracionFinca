/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Cristoffer
 */
public class Cuadrillas {
    private int codigoCuadrilla;
    private ArrayList<Jornaleros> jornaleros;
    private String nombreCuadrilla;
    private ArrayList<Tractorista> tractorista;
    private Manijero manijero;
    
     public Cuadrillas(int codigo) {
        this.codigoCuadrilla= codigo;
     }

    public Cuadrillas(int codigo,String nombreCuadrilla) {
        this.codigoCuadrilla= codigo;
        this.nombreCuadrilla = nombreCuadrilla;
    }

    public Cuadrillas(int codigoCuadrilla, ArrayList<Jornaleros> jornaleros, ArrayList<Tractorista> tractorista, Manijero manijero) {
        this.codigoCuadrilla = codigoCuadrilla;
        this.jornaleros = jornaleros;
        this.tractorista = tractorista;
        this.manijero = manijero;
    }
        public Cuadrillas(int codigoCuadrilla,String nombreCuadrilla, ArrayList<Jornaleros> jornaleros, ArrayList<Tractorista> tractorista, Manijero manijero) {
        this.codigoCuadrilla = codigoCuadrilla;
        this.nombreCuadrilla=nombreCuadrilla;
        this.jornaleros = jornaleros;
        this.tractorista = tractorista;
        this.manijero = manijero;
    }

    public ArrayList<Tractorista> getTractorista() {
        return tractorista;
    }

    public void setTractorista(ArrayList<Tractorista> tractorista) {
        this.tractorista = tractorista;
    }

    public Manijero getManijero() {
        return manijero;
    }

    public void setManijero(Manijero manijero) {
        this.manijero = manijero;
    }
    

    public String getNombreCuadrilla() {
        return nombreCuadrilla;
    }

    public void setNombreCuadrilla(String nombreCuadrilla) {
        this.nombreCuadrilla = nombreCuadrilla;
    }
   
    public Cuadrillas(int codigoCuadrilla, ArrayList<Jornaleros> jornaleros) {
        this.codigoCuadrilla = codigoCuadrilla;
        this.jornaleros = jornaleros;
    }

    public int getCodigoCuadrilla() {
        return codigoCuadrilla;
    }

    public void setCodigoCuadrilla(int codigoCuadrilla) {
        this.codigoCuadrilla = codigoCuadrilla;
    }

    public ArrayList<Jornaleros> getJornaleros() {
        return jornaleros;
    }

    public void setJornaleros(ArrayList<Jornaleros> jornaleros) {
        this.jornaleros = jornaleros;
    }

    @Override
    public String toString() {
        return codigoCuadrilla + "--" + nombreCuadrilla;
    }

   
    
    
    public String MostrarManijero(){
        
        String nombreCompleto=manijero.getNombre()+" "+manijero.getApellidos();
        if(nombreCompleto.equals(null+" "+null)){
        nombreCompleto="Sin manijero Asignado";
    }else{
        return nombreCompleto;    
        }
        return nombreCompleto;
    }
    
    public String MostrarTractoristas(){
        String nombreCompleto=null;
        for (Tractorista tr : tractorista) {
            nombreCompleto=tr.getNombre()+" "+tr.getApellidos();
           }
        return nombreCompleto;
        
    }

   
    
    
    
    
    
    
}
