/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.Cuadrillas;
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
public class ConsultasCuadrillas {
      ConexionBD cbd = new ConexionBD();
      public ConsultasCuadrillas() {
    }
      
      //----------------------------------CRUD CUADRILLAS----------------------------------
 /*
 Insertar Cuadrillas
 */
 public  boolean InsertarCuadrillas(int codigo,String nombre) {
     boolean resultado=false;
		String sql;
		PreparedStatement ps;
		try {
                    Connection conn = cbd.abrirConexion();
			 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
			 sql = "INSERT INTO `cuadrilla`(`Cod_Cuadrilla`, `nombre`) VALUES (?,?)";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1,codigo);
	            ps.setString(2,nombre);            
	            

	            ps.executeUpdate();
	            resultado=true;
                    cbd.cerrarConexion();
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
	        }
                return resultado;
	}
 
 
 /*
 Borrar Cuadrilla
 */
 public boolean borraCuadrilla(int codtrabaj) {
     boolean resultado=false;
		try {
		PreparedStatement ps;
		String sql = "DELETE FROM cuadrilla WHERE Cod_Cuadrilla="+codtrabaj+";";
				Connection conn = cbd.abrirConexion();

			ps = conn.prepareStatement(sql);		           
		 
		int rowsUpdated = ps.executeUpdate();
		if (rowsUpdated > 0) {
		    resultado=true;
		}
                cbd.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return resultado;
	}

 /**
  * Buscamos la cuadrilla
  * @param codigo
  * @return 
  */
    public Cuadrillas buscarCuadrilla(int codigo) {
         Cuadrillas cuadrilla = null;        
        try {
            PreparedStatement ps;
            String sql = "SELECT * FROM cuadrilla c WHERE c.Cod_Cuadrilla="+codigo+";";
            Connection conn = cbd.abrirConexion();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                int cod = rs.getInt(1);
                String nombre = rs.getString(2);
                
                cuadrilla=new Cuadrillas(cod, nombre);
                
                
    }
        cbd.cerrarConexion();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  return cuadrilla;       
   
    }
      
      
}
