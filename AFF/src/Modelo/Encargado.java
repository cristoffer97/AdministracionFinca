/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
//import principal.Comando;
//import principal.VentanaPrincipal;

/**
 *
 * @author Cristoffer
 */
public class Encargado extends Trabajadores{
private Socket skcliente;
	private DataInputStream flujoentrada;
	private DataOutputStream flujosalida;
	private ObjectOutputStream flujosalidaObjeto;
	private ObjectInputStream flujoentradaObjeto;
   public Encargado() {
    }

    public Encargado(int Cod_Trabajador, int telefono, String nombre, String apellidos, int Cuadrilla, boolean Podador, String tipoTrabajador) {
        super(Cod_Trabajador, telefono, nombre, apellidos, Cuadrilla, Podador, tipoTrabajador);
    }

   
    public Encargado(Socket skcliente) {
		this.skcliente=skcliente;
	}

	public void abrirFlujos() {
		try {
			flujoentrada=new DataInputStream(skcliente.getInputStream());
		    flujosalida=new DataOutputStream(skcliente.getOutputStream()); 
		   
		    flujosalidaObjeto=new ObjectOutputStream(skcliente.getOutputStream());
		    flujoentradaObjeto=new ObjectInputStream(skcliente.getInputStream());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void cerrarFlujos() {
		try {
			flujoentrada.close();
			flujosalida.close();
			flujosalidaObjeto.close();
			flujoentradaObjeto.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
    
}
