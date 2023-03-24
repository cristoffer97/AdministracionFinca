/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.Trabajadores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristoffer
 */
public class ConsultasTrabajadores {
     ConexionBD cbd = new ConexionBD();
      public ConsultasTrabajadores() {
    }
//-----------------------------------CRUD SOBRE LA TABLA DE TRABAJADORES
 /*
 Actualizamos los datos del trabajador en nuestra base de datos
 */ 
 public boolean actualizarDatosdeTrabajador(int codtrabaj, String nombre, String apellido, int telefono, int cuadrilla, boolean podador, int tipotrabajador) {
        boolean resultado=false;
        try {
		PreparedStatement ps;
		String sql = "UPDATE trabajadores SET nombre=?, apellido=?, telefono=?, Cuadrilla=?,Podador=?, Tipo=? WHERE Cod_Trabajador="+codtrabaj+";";
		//String sql = "UPDATE `trabajadores` SET nombre=?,apellido=?,`telefono=?,Cuadrilla=?,`podador=?,Tipo=7]' WHERE 1";
		 
		//PreparedStatement statement = conn.prepareStatement(sql);
		Connection conn = cbd.abrirConexion();
			ps = conn.prepareStatement(sql);
		
             ps.setString(1,nombre);
             ps.setString(2, apellido);
             ps.setInt(3, telefono);
             ps.setInt(4, cuadrilla);
             ps.setBoolean(5, podador);
             ps.setInt(6, tipotrabajador);
            
            
		 
		int rowsUpdated = ps.executeUpdate();
		if (rowsUpdated > 0) {
		    resultado=true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resultado;
    }

/*
    Metodo que borra el trabajador de la Base De Datos
    */
 public boolean BorrarTrabajador(int codtrabaj) {
     boolean resultado=false;
		try {
		PreparedStatement ps;
		String sql = "DELETE FROM trabajadores WHERE Cod_Trabajador="+codtrabaj+";";		
		Connection conn = cbd.abrirConexion();

                ps = conn.prepareStatement(sql);		     	 
		int rowsUpdated = ps.executeUpdate();
		if (rowsUpdated > 0) {
		    resultado=true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
                return resultado;
	}
 
 
/*
    Metodo que ingresa el trabajador en la Base De Datos
    */

 public boolean IngresarTrabajador(int codtrabaj,String nombre,String apellido,int telefono,int cuadrilla,boolean podador,int tipo){
     boolean resultado=false;
     String sql;
		PreparedStatement ps;
		try {
                    ConexionBD cbd = new ConexionBD();
                    Connection conn = cbd.abrirConexion();
			 
			// Preparamos la consulta
			 sql = "INSERT INTO `trabajadores`(`Cod_Trabajador`, `nombre`, `apellido`, `telefono`, `Cuadrilla`, `podador`, `Tipo`) VALUES (?,?,?,?,?,?,?)";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1,codtrabaj);
	            ps.setString(2,nombre );
	            ps.setString(3,apellido );
	            ps.setInt(4,telefono);
	            ps.setInt(5,cuadrilla );
                    ps.setBoolean(6, podador); 
                    ps.setInt(7, tipo);
	            

	            ps.executeUpdate();
	            resultado=true;
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
	        }
                return resultado;
 }

 /**
  * Metodo que busca a nuestro trabajador en la base de datos
  * @param codigodTrabajador
  * @return 
  */
    public Trabajadores buscarTrabajador(int codigodTrabajador) {
        Trabajadores trabajador = null;
        boolean pod=false;
        try {
            PreparedStatement ps;
            String sql = "SELECT t.nombre,t.apellido,t.telefono,t.Cuadrilla,tt.nombre,t.podador " +
                        "FROM trabajadores t inner JOIN tipo_trabajador tt on tt.id_Tipo=t.Tipo " +
                        "WHERE t.Cod_Trabajador="+codigodTrabajador+";";
            Connection conn = cbd.abrirConexion();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString(1);
                String apellido = rs.getString(2);
                int tel = rs.getInt(3);
                //String telefono = String.valueOf(tel);
                int cuadrilla = rs.getInt(4);              
                String tipoTrabajador =rs.getString(5);
                int podador = rs.getInt(6);
                if(podador==1){
                    pod=true;
                }
                trabajador=new Trabajadores(tel, nombre, apellido, cuadrilla, pod, tipoTrabajador);                
                
                
    }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  return trabajador;       


    }   
/**
  * Metodo que comprueba que el codigo del trabajador es valido
  * @param codtrabaj
  * @return 
  */
    
    public boolean comprobarCodigoValido(int codtrabaj) {
        boolean resultado=false;
		try {
		PreparedStatement ps;
		String sql = "SELECT * FROM trabajadores WHERE Cod_Trabajador="+codtrabaj+";";		
		Connection conn = cbd.abrirConexion();

                ps = conn.prepareStatement(sql);		     	 
		int rowsUpdated = ps.executeUpdate();
		if (rowsUpdated < 0) {
		    resultado=true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
                return resultado;
	}
    
      
}
