/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristoffer
 */
public class ConsultasTractor {
    ConexionBD cbd = new ConexionBD();
      public ConsultasTractor() {
    }

 /*
  Insertar Tractoristas
 */
 public  boolean InsertarTractor(int codigo,String nombre,int herr) {
     boolean resultado=false;
		String sql;
		PreparedStatement ps;
		try {
                    	Connection conn = cbd.abrirConexion();

			 //conexion= DriverManager.getConnection ("jdbc:mysql://localhost/aff","root", "");
			// Preparamos la consulta
			 sql = "INSERT INTO `tractores`(`Cod_Tractor`, `Matricula`,`herramientas`) VALUES (?,?,?)";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1,codigo);
	            ps.setString(2,nombre);            
	            ps.setInt(3,herr);

	            ps.executeUpdate();
                    resultado=true;
	            
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
	        }
                
                return resultado;
	}
  /*
  Borrar Tractoristas
 */
 public boolean BorrarTractor(int cod_Tractor) {
     boolean resultado=false;
		try {
		PreparedStatement ps;
		String sql = "DELETE FROM `tractores` WHERE Cod_Tractor="+cod_Tractor+";";
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
  actualizar Tractoristas
 */
public boolean actualizarTractor(int codtrabaj, String nombre, int herramienta) {
    boolean resultado=false;
		try {
		PreparedStatement ps;
		String sql = "UPDATE tractores SET matricula=?, herramientas=? WHERE Cod_Tractor="+codtrabaj+";";
		
		 Connection conn = cbd.abrirConexion();
		//PreparedStatement statement = conn.prepareStatement(sql);
		
			ps = conn.prepareStatement(sql);
		
             ps.setString(1,nombre);
             ps.setInt(2, herramienta);
            		 
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
      
      
}
