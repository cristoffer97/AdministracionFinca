/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.*;
import Modelo.Cuadrillas;
import Modelo.H_CONECTADA;
import Modelo.Jornaleros;
import Modelo.Manijero;
import Modelo.Tarea;
import Modelo.Tractor;
import Modelo.Tractorista;
import Modelo.Trabajadores;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 *
 * @author Cristoffer
 */
public class ConsultasMYSQL implements Configuracion {
    //private static Connection conexion;
    ConexionBD cbd = new ConexionBD();

    public ConsultasMYSQL() {
    }

   /* public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        ConsultasMYSQL.conexion = conexion;
    }*/
    
 
/*
    Obtenemos todas las cuadrillas con su lista de jornaleros, su manijero asignado y su lista de tractoristas
    */
public ArrayList<Cuadrillas> obtenerCuadrillas(){
     ArrayList<Cuadrillas> listaCuadrillas=new ArrayList<>();
  
        try {
                       
                    Connection conn = cbd.abrirConexion();
			 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery ("select * from cuadrilla");
			while (rs.next())
			{   int cuadrilla=rs.getInt(1);
                           String nombre=rs.getString(2);
                            Manijero mani=obtenerManijero(cuadrilla);
                            ArrayList<Tractorista> listaTractorista=obtentenerTractoristas(cuadrilla);
                            ArrayList<Jornaleros> listaJornaleros=obtenerJornaleros(cuadrilla);
                            Cuadrillas c=new Cuadrillas(cuadrilla,nombre,listaJornaleros,listaTractorista,mani);
                            listaCuadrillas.add(c);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         cbd.cerrarConexion();
     return listaCuadrillas;
 }
    


/*
    Obtenemos a los tractoristas de las distintas cuadrillas
    */
public ArrayList<Tractorista> obtentenerTractoristas(int Cuadrilla) {
      ArrayList<Tractorista> listaTractorista=new ArrayList<>();
        try {
			 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
                         Connection conn = cbd.abrirConexion();
			// Preparamos la consulta
String sql="SELECT t.Cod_Trabajador,t.nombre,t.apellido,t.telefono,t.Cuadrilla,t.podador,tt.nombre FROM ((trabajadores t inner JOIN cuadrilla c on t.Cuadrilla=c.Cod_Cuadrilla)" +
"      inner JOIN tipo_trabajador tt on t.Tipo=tt.id_Tipo)\n" +
"WHERE   tt.nombre LIKE 'Tractorista' AND c.Cod_Cuadrilla="+Cuadrilla+";";
			Statement s = conn.createStatement();
                        ResultSet rs = s.executeQuery (sql);
			//ResultSet rs = s.executeQuery ("SELECT * FROM trabajadores t inner JOIN cuadrilla c on t.Cuadrilla=c.Cod_Cuadrilla where t.Tractorista=1 and t.Cuadrilla="+Cuadrilla+";");
			while (rs.next()){  
                             int codigo=rs.getInt(1);
                            String nombre=rs.getString (2);
                            String apellidos=rs.getString (3);
                            int telefono=rs.getInt(4);                          
                            int cuadrilla=rs.getInt(5);
                            boolean poda=rs.getBoolean(6); 
                            String tipo=rs.getString(7);
                            Tractorista tr=new Tractorista(codigo, codigo, telefono, nombre, apellidos, cuadrilla, poda, tipo);
                            listaTractorista.add(tr);
                            
			}
                       		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cbd.cerrarConexion();
        return listaTractorista;
      
    }

/*
    Obtenemos a los jornaleros de las distintas cuadrillas
    */
public ArrayList<Jornaleros> obtenerJornaleros(int Cuadrilla){
        ArrayList<Jornaleros> listaJornaleroses=new ArrayList<>();
        try {
			 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
                           Connection conn = cbd.abrirConexion();
			// Preparamos la consulta
    String sql="SELECT t.Cod_Trabajador,t.nombre,t.apellido,t.telefono,t.Cuadrilla,t.podador,tt.nombre FROM ((trabajadores t inner JOIN cuadrilla c on t.Cuadrilla=c.Cod_Cuadrilla)\n" +
"      inner JOIN tipo_trabajador tt on t.Tipo=tt.id_Tipo)WHERE c.Cod_Cuadrilla="+Cuadrilla+";";
			Statement s = conn.createStatement();
                        ResultSet rs = s.executeQuery (sql);
//			ResultSet rs = s.executeQuery ("SELECT * FROM trabajadores t WHERE t.manijero=0 and t.Tractorista=0 and t.Encargador=0 and t.Cuadrilla="+Cuadrilla+";");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{   int codigo=rs.getInt(1);
                            String nombre=rs.getString (2);
                            String apellidos=rs.getString (3);
                            int telefono=rs.getInt(4);                          
                            int cuadrilla=rs.getInt(5);
                            boolean poda=rs.getBoolean(6); 
                            String tipo=rs.getString(7);
                            Jornaleros j=new Jornaleros(codigo, telefono, nombre, apellidos, cuadrilla, poda, tipo);
                            listaJornaleroses.add(j);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cbd.cerrarConexion();
        return listaJornaleroses;
        
    }

/**
 * Obtenemos el manijero de la cuadrilla
 * @param Cuadrilla codigo de la cuadrilla
 * @return 
 */
 public Manijero obtenerManijero(int Cuadrilla) {
        Manijero m=new Manijero();
        try {               
                        Connection conn = cbd.abrirConexion();
                	 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
                        String sql="SELECT t.Cod_Trabajador,t.nombre,t.apellido,t.telefono,t.Cuadrilla,t.podador,tt.nombre FROM ((trabajadores t inner JOIN cuadrilla c on t.Cuadrilla=c.Cod_Cuadrilla)" +
"      inner JOIN tipo_trabajador tt on t.Tipo=tt.id_Tipo)\n" +
"WHERE   tt.nombre LIKE 'Manijero' AND c.Cod_Cuadrilla="+Cuadrilla+";";
			Statement s = conn.createStatement();
                        ResultSet rs = s.executeQuery (sql);
		
			while (rs.next())
			{  
                             int codigo=rs.getInt(1);
                            String nombre=rs.getString (2);
                            String apellidos=rs.getString (3);
                            int telefono=rs.getInt(4);                          
                            int cuadrilla=rs.getInt(5);
                            boolean poda=rs.getBoolean(6); 
                            String tipo=rs.getString(7);
                            m=new Manijero(codigo, telefono, nombre, apellidos, cuadrilla, poda, tipo);
                
                            
                            
			}              
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cbd.cerrarConexion();
        
       return m;
    }
 

 
  /*
 Obtenemos a todos los trabjadores de la base de datos
 */
 public ArrayList<Trabajadores> sacarTrabajadoresdeBD(){
       ArrayList<Trabajadores> Trabajadores=new ArrayList<>();
        try {
                         Connection conn = cbd.abrirConexion();
			 //conn= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery ("SELECT t.Cod_Trabajador,t.nombre,t.apellido,t.telefono,t.Cuadrilla,t.podador,tt.nombre\n" +
                                                        "FROM trabajadores t inner JOIN tipo_trabajador tt on t.Tipo=tt.id_Tipo;");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{   int codigo=rs.getInt(1);
                            String nombre=rs.getString (2);
                            String apellidos=rs.getString (3);
                            int telefono=rs.getInt(4);
                            int cuadrilla=rs.getInt(5);
                            boolean poda=rs.getBoolean(6);
                            String tipoTrabajador=rs.getString (7);
                            
                            Trabajadores t=new Trabajadores(codigo, telefono, nombre, apellidos, cuadrilla, poda, tipoTrabajador);
                            Trabajadores.add(t);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Trabajadores;
    }

  /*
 Obtenemos a todos los tractores de la base de datos
 */
 public ArrayList<Tractor> sacarTractores(){
       ArrayList<Tractor> tractores=new ArrayList<>();
        try {   
            Connection conn = cbd.abrirConexion();
			// conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery ("SELECT  t.Cod_Tractor,t.Matricula,h.Cod_Herramienta,h.Nombre\n" +
                                                        "FROM tractores t inner JOIN herramientas h on t.herramientas=h.Cod_Herramienta;");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{   int codigotractor=rs.getInt(1);
                            String matricula=rs.getString (2);
                            int codigoherramienta=rs.getInt(3);
                            String nombre=rs.getString (4);
                            H_CONECTADA h=new H_CONECTADA(codigoherramienta,nombre);
                            Tractor t=new Tractor(codigotractor, matricula, h);
                            tractores.add(t);
                        }          
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return tractores;
    }
 





/**
 * Validamos los datos de nuestro trabajador
 * @param nombre
 * @param codigo
 * @return 
 */
public boolean validardatos(String nombre,int codigo){
boolean valido = false;   
try {                      
        String consulta="SELECT * FROM trabajadores t INNER JOIN tipo_trabajador tt on t.Tipo=tt.id_Tipo WHERE tt.nombre like 'Encargado' AND T.nombre LIKE '"+nombre+"' AND t.Cod_Trabajador="+codigo+";";
        Connection conn = cbd.abrirConexion();
                	 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
                         // Preparamos la consulta
			Statement s = conn.createStatement();                         
                        ResultSet rs=s.executeQuery(consulta);
                                        
                        int cantidad=0;            
                        while(rs.next()){
                            cantidad++;
                        }                        
                        if(cantidad>0){
                            valido=true;                               
                          }                  
                     
                                                                   
                        
    }catch(SQLSyntaxErrorException e){
        
       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


return valido;
}

/**
 * Obtenemos todas la cuadrilals disponibles
 * @return 
 */
    public ArrayList<Cuadrillas> comprobarCuadrillas() {
        ArrayList<Cuadrillas> lista=new ArrayList<>();
    try {
                Connection conn = cbd.abrirConexion();

			// conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery ("select * from cuadrilla");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{   int codigo=rs.getInt(1);
                            String nombreCuadrilla= rs.getString(2);
                                                        
                            Cuadrillas c=new Cuadrillas(codigo,nombreCuadrilla);
                            lista.add(c);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    return lista;
    }
/**
     * Obtenemos los tipos de trabajador
     * @param codigoCuadrilla
     * @return 
     */
    public ArrayList<String> comprobarTipos() {
        ArrayList<String> lista=new ArrayList<>();
        try {
                    Connection conn = cbd.abrirConexion();

			// conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery ("select nombre from tipo_trabajador");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next()){
                            String nombreTipo= rs.getString(1);                              
                            lista.add(nombreTipo);
                                                       
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return lista;
    }

    /**
     * Obtenemos la cantidad de personas por cuadrillas que tenemos
     * @param codigoCuadrilla
     * @return 
     */

    public int obtenerCantidadPersonas(int codigoCuadrilla) {
    int totalPersonas=0;
    
      try {
                         Connection conn = cbd.abrirConexion();
			 //conn= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery ("SELECT COUNT(t.Cod_Trabajador)\n" +
                        "FROM cuadrilla c inner JOIN trabajadores t on c.Cod_Cuadrilla=t.Cuadrilla\n" +
                        "WHERE c.Cod_Cuadrilla="+codigoCuadrilla+"\n" +
                        "GROUP BY c.Cod_Cuadrilla;");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{   int codigo=rs.getInt(1);
                        totalPersonas=codigo;
                          }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
    
    return totalPersonas;
    }

    /**
     * Obtenemos todas las herramientas de nuestra BD
     * @return 
     */
    public ArrayList<H_CONECTADA> comprobarHerramientas() {
    ArrayList<H_CONECTADA> listaHerramientas=new ArrayList<>();
         try {
			Connection conn = cbd.abrirConexion();
			// Preparamos la consulta
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery ("select * from herramientas");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{   int codigo=rs.getInt(1);
                            String nombreHerramienta= rs.getString(2);
                                                        
                            H_CONECTADA h=new H_CONECTADA(codigo,nombreHerramienta);
                            listaHerramientas.add(h);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    return listaHerramientas;
    }

  
/**
 * Metodo que nos guarda en la tabla de fichaje de nuestros trabajadores
 * @param codigo 
 */
    public void FicharTrabajadorEntrada(int codigo) {
        String sql;
		PreparedStatement ps;
		try {
                    ConexionBD cbd = new ConexionBD();
                    Connection conn = cbd.abrirConexion();
			 
			// Preparamos la consulta
                         sql = "INSERT INTO `registrofichar`(`Cod_Trabajador`) VALUES (?)";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1,codigo);	          
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Se han fichado de manera segura");
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
	        }
        
                   cbd.cerrarConexion();
        
        
    }

    /**
     * Metodo que nos comprueba que el codigo introducido esta en uso
     * @param codigo
     * @return 
     */
    public boolean existeTrabajador(int codigo) {
      boolean valido = false;   
try {                      
        String consulta="SELECT * FROM trabajadores WHERE Cod_Trabajador="+codigo+";";
        Connection conn = cbd.abrirConexion();
                	 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
                         // Preparamos la consulta
			Statement s = conn.createStatement();
                         
                        ResultSet rs=s.executeQuery(consulta);
                                        
                        int cantidad=0;            
                        while(rs.next()){
                            cantidad++;
                        }                        
                        if(cantidad>0){
                            valido=true;                               
                          }                  
                     
                                                                   
                        
    }catch(SQLSyntaxErrorException e){
        
       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


return valido;
    }

    /**
     * Metoto que nos indica la fecha/hora de salida de nuestro trabajador
     * @param codigo 
     */
    public void FicharTrabajadorSalida(int codigo) {
        String sql;
		PreparedStatement ps;
		try {
                    ConexionBD cbd = new ConexionBD();
                    Connection conn = cbd.abrirConexion();
			 
			// Preparamos la consulta			
                         sql = "UPDATE `registrofichar` SET `HSalida`= now() WHERE Cod_Trabajador="+codigo+" AND DAY(HEntada)=DAY(NOW());";
	            ps = conn.prepareStatement(sql);	          
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Se han fichado de manera segura");
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
	        }
        
        
        
        
    }

    /**
     *Metodo que nos controla que no agregemo fichemos al mismo trabajador a la entrada o salida mas de una vez
     * @param codigo
     * @return 
     */
    public boolean trabajadorDuplicado(int codigo) {
      boolean valido = true;   
try {                      
        String consulta="SELECT * FROM registrofichar WHERE Day(Hentada)=Day(now()) AND Cod_Trabajador="+codigo+";";
        Connection conn = cbd.abrirConexion();
                	 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
                         // Preparamos la consulta
			Statement s = conn.createStatement();
                         
                        ResultSet rs=s.executeQuery(consulta);
                                        
                        int cantidad=0;            
                        while(rs.next()){
                            cantidad++;
                        }                        
                        if(cantidad>0){
                            valido=false;                               
                          }                  
                     
                                                                   
                        
    }catch(SQLSyntaxErrorException e){
        
       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


return valido;
    
    }
    
    /**
     * Obtenemos todos los registros de nuestras tareas
     * @return 
     */
public ArrayList<Tarea> ObtenerTareas() {

    ArrayList<Tarea> lista=new ArrayList<>();
    try {
                Connection conn = cbd.abrirConexion();
                    String sql="SELECT r.ID_Cuadrilla,t.nombre,f.nombre,f.Variedad,r.TipoRecogida,r.CantidadPaleps,r.fecha\n" +
                        "FROM ((registro r inner JOIN tareas t on r.ID_Tarea=t.Cod_Tarea)\n" +
                        "inner JOIN fruta f on f.Cod_Fruta=r.ID_Fruta)\n" +
                        "Order By r.fecha Desc;";                    
                    
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery (sql);
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next()){   
                            int codigoCuadrilla=rs.getInt(1);
                            //String nombreCuadrilla=rs.getString(2);
                            String nombreTarea= rs.getString(2);
                            String nombreFruta= rs.getString(3);
                            String VariedadFruta= rs.getString(4);
                            String TipoRecogida= rs.getString(5);
                            String Cantidad= rs.getString(6);
                            int cantidadPaleps=Integer.parseInt(Cantidad);
                            Date fech = rs.getDate(7);
                            String Fecha = String.valueOf(fech);
                            Cuadrillas cuadrilla=new Cuadrillas(codigoCuadrilla);
                          Tarea tarea=new Tarea(cuadrilla, nombreTarea, nombreFruta, VariedadFruta,TipoRecogida,cantidadPaleps,Fecha);
                          
                          lista.add(tarea);                    
                            
			}
                        
                        cbd.cerrarConexion();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    return lista;
    
    
    }

/**
 * Obtenemos todos los tractores junto con las herramientas conectadas
 * @return 
 */

    public ArrayList<Tractor> comprobarTractores() {
       
    ArrayList<Tractor> lista=new ArrayList<>();
    try {
                Connection conn = cbd.abrirConexion();
                    String sql="SELECT t.Cod_Tractor,t.Matricula,h.Cod_Herramienta,h.Nombre\n" +
"FROM tractores t inner JOIN herramientas h on t.herramientas=h.Cod_Herramienta;";
			
                    
                    
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery (sql);
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next()){   
                            int codigoTractor=rs.getInt(1);
                            String Matricula=rs.getString(2);
                             int codigoHerramienta=rs.getInt(3);
                            String nombreHerramienta= rs.getString(4);
                            //H_CONECTADA h=new H_CONECTADA(codigoHerramienta, nombreHerramienta);
                            Tractor t=new Tractor(codigoTractor, Matricula);
                                        
                            lista.add(t);
                            
			}
                        
                        cbd.cerrarConexion();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    return lista;
     
    }

    /**
     * Obtenemos los registros de los tractores y sus tractoristas
     * @return 
     */
    public String[] obtenertractresAsignados() {
        int cod=0;
        String codigo = null,Cod_Tract = null;
        Date fecha = null;
         
        
         try {   
            Connection conn = cbd.abrirConexion();
			// conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
                        String sql="SELECT tt.id_Tractor,tt.Tractorista,tt.Fecha FROM `tractor_tractorista` tt";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery (sql);
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next()){
                            cod=rs.getInt(1);
                            codigo=String.valueOf(cod);
                            Cod_Tract=rs.getString (2);
                            fecha = rs.getDate(3);
                            
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         String[] trac={codigo,Cod_Tract,fecha.toString()};

         return trac;
    }
    
    /**
     * Obtenemos a todos los tractoristas de nuestra BD
     * @return 
     */

    public ArrayList<Tractorista> comprobarTractoristas() {
        ArrayList<Tractorista> lista=new ArrayList<>();
    try {
                Connection conn = cbd.abrirConexion();
                    String sql="    SELECT t.Cod_Trabajador,t.nombre,t.Cuadrilla\n" +
                                    "FROM trabajadores t inner JOIN tipo_trabajador tt on tt.id_Tipo=t.Tipo\n" +
                                    "WHERE tt.nombre LIKE 'Tractorista';";
			
                    
                    
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery (sql);
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next()){   
                            int codigoTractorista=rs.getInt(1);
                            String nombre=rs.getString(2);
                             int Cuadrilla=rs.getInt(3);
                            
                            
                            Tractorista t=new Tractorista(codigoTractorista, nombre, Cuadrilla);
                                        
                            lista.add(t);
                            
			}
                        
                        cbd.cerrarConexion();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    return lista;
    }


    

   

 
    


}//Fin de clase

