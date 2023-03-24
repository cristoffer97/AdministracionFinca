/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cristoffer
 */
public class Tractor {
   private int cod_tractor;
   private String matricula;
     private H_CONECTADA herramienta;

    public Tractor(int cod_tractor, String matricula) {
        this.cod_tractor = cod_tractor;
        this.matricula = matricula;
    }

    public Tractor(int cod_tractor, String matricula, H_CONECTADA herramienta) {
        this.cod_tractor = cod_tractor;
        this.matricula = matricula;
        this.herramienta = herramienta;
    }

    public H_CONECTADA getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(H_CONECTADA herramienta) {
        this.herramienta = herramienta;
    }
    
    

    public int getCod_tractor() {
        return cod_tractor;
    }

    public void setCod_tractor(int cod_tractor) {
        this.cod_tractor = cod_tractor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "cod_tractor=" + cod_tractor + ", matricula=" + matricula + ", herramienta=" + herramienta + '}';
    }
    
    
    public String mostrarinformacion(){
        String cadena="Codigo: " + cod_tractor;
        return cadena;
    }


}