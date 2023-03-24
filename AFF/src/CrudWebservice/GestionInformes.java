/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrudWebservice;

import javax.swing.JOptionPane;
import modelo.Informes;



public class GestionInformes {
    static boolean realizado=false;
    
    /**
     * Metodo que nos confirma si el usuario que esta intentando acceder al sistema es un perito o no
     * @param Codigo
     * @return 
     */

    static public boolean loguear(String Codigo) {
        String url = Constantes.ACCESOALSISTEMA;
        String valores = "codigo=" + Codigo;

        String jsonResultado = HttpRequest.GET_REQUEST(url, valores);
    //    System.out.println(jsonResultado);
         if(jsonResultado.equals("Usuario Valido")){
            realizado=true;
    }
        return realizado;
        
    }
    
    /**
     * Metodo que inserta un registro en nuestra tabla
     * @param dni
     * @param dni1
     * @param tipo
     * @param descripcion
     * @return 
     */
    static public boolean insertar(String dni,String dni1,String tipo,String descripcion) {
        String url = Constantes.INSERTAR_INFORMES;
        String valores = "codigo=" + dni+"&&id_Fruta="+dni1+"&&Asunto="+tipo+"&&descripcion="+descripcion;
        String jsonResultado = HttpRequest.POST_REQUEST(url, valores);
        
        if(jsonResultado.equals("Informe Insertado")){
            realizado=true;
    }
        return realizado;
        
     
    }
    /**
     * * Metodo que modifica un registro de nuestra tabla
     * @param Id
     * @param perito
     * @param fruta
     * @param asunto
     * @param descripcion
     * @return 
     */
    
    static public boolean modificar(String Id,String perito,String fruta,String asunto,String descripcion) {
        String url = Constantes.MODIFICAR_INFORME;
        String valores = "Id=" + Id+"&&Perito=" + perito+"&&id_Fruta="+fruta+"&&Asunto="+asunto+"&&descripcion="+descripcion;

        String jsonResultado = HttpRequest.POST_REQUEST(url, valores);
       
        if(jsonResultado.equals("Informe modificado")){
            realizado=true;
    }
        return realizado;
    }
    /**
     * * Metodo que borra un registro en nuestra tabla
     * @param Id
     * @return 
     */
     static public boolean borrar(String Id) {
        String url = Constantes.BORRARINFORMES;
        String valores = "codigo=" + Id;

        String jsonResultado = HttpRequest.POST_REQUEST(url, valores);
        // System.out.println(jsonResultado);
     if(jsonResultado.equals("Informe borrado")){
            realizado=true;
    }
        return realizado;
    }
/**
 * * Metodo que busca un registro en nuestra tabla
 * @param id
 * @return 
 */
    public static Informes buscarRegistro(String id) {
        Informes info = null;
         String url = Constantes.BUSCARINFORME;
        String valores = "codigo="+id;

        String jsonResultado = HttpRequest.GET_REQUEST(url, valores);
        //System.out.println("El resultado es "+jsonResultado);
         try{
         if(jsonResultado.equals(null)){
             return info;
         }else{
       String[] informes=jsonResultado.split(",");
        for (int i = 0; i < informes.length; i++) {
            info=new Informes(informes[2], informes[3], informes[0], informes[1]);
        }
         }     
    
    }catch(ArrayIndexOutOfBoundsException e){
         //           JOptionPane.showMessageDialog(null, "No existe registro en la base de datos con ese ID");    
}catch(java.lang.NullPointerException e){
                    JOptionPane.showMessageDialog(null, "Introduce un ID VALIDO");    
}
    
         return info;
    }

    /**
     * * Metodo que obtenemos todos los ids que existen en nuestra tabla
     * @return 
     */
    public static String[] obtenertodos() {
        String url = Constantes.OBTENERTODOS;       

        String jsonResultado = HttpRequest.GET_REQUEST1(url);
        //System.out.println(jsonResultado);
        
        
        String[] informes=jsonResultado.split("},");
        //String[] informes=jsonResultado.split(",");
        return informes;
        //Decodificar el json
        //Gson gson = new Gson();
        
        
           // ArrayList<Informes> personas = gson.fromJson(jsonResultado, new TypeToken<ArrayList<Informes>>() {}.getType());

           // for (Informes persona : personas) {
         //   System.out.println(persona.getAsunto()+ " " + persona.getCodigo()+ " " + persona.getDescripcion()+ " " + persona.getId_Fruta());
                
}
}

