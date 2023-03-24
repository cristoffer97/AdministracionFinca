/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Modelo.Cuadrillas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import controlador.ConsultasCuadrillas;

/**
 *
 * @author Cristoffer
 */
public class testGestionCuadrillas {
    
    public testGestionCuadrillas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


     /**
     * Prueba de Ingreso de una cuadrilla
     */
     @Test
     public void testIngresarTrabajador(){
        //instance=new Cartelera();        
        boolean respuesta_espareada=true;
        ConsultasCuadrillas consultas =new ConsultasCuadrillas();       
         boolean resultado=consultas.InsertarCuadrillas(4510, "MARY");
         assertEquals(respuesta_espareada, resultado);
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
     
     /**
     * Prueba de borrado de trabajador
     */
     
     @Test
     public void testBorrarTrabajador(){
        //instance=new Cartelera();        
        boolean respuesta_espareada=true;
        ConsultasCuadrillas consultas =new ConsultasCuadrillas();       
         boolean resultado=consultas.borraCuadrilla(1202);
         assertEquals(respuesta_espareada, resultado);
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
     
          @Test
     public void testBuscarCuadrilla(){
        
        int respuesta_espareada=97;
        ConsultasCuadrillas consultas =new ConsultasCuadrillas();       
         Cuadrillas c=consultas.buscarCuadrilla(97);
         assertEquals(respuesta_espareada, c.getCodigoCuadrilla());
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
    
    
    
    
}
