/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import controlador.ConsultasTractor;

/**
 *
 * @author Cristoffer
 */
public class testGestionTractores {
    
    public testGestionTractores() {
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
     * Prueba de modificacion de trabajador
     */
      @Test
     public void testModificarTractor(){
        //instance=new Cartelera();        
        boolean respuesta_espareada=true;
        ConsultasTractor consultas =new ConsultasTractor();       
         boolean resultado=consultas.actualizarTractor(1202, "M1A2R3Y",1);
         assertEquals(respuesta_espareada, resultado);
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
     /**
     * Prueba de Ingreso de trabajador
     */
     @Test
     public void testIngresarTractor(){
        //instance=new Cartelera();        
        boolean respuesta_espareada=true;
          ConsultasTractor consultas =new ConsultasTractor();           
         boolean resultado=consultas.InsertarTractor(4510, "7M9A9R7Y",1);
         assertEquals(respuesta_espareada, resultado);
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
     
     /**
     * Prueba de borrado de trabajador
     */
     
     @Test
     public void testBorrarTractor(){
        //instance=new Cartelera();        
        boolean respuesta_espareada=true;
         ConsultasTractor consultas =new ConsultasTractor();     
         boolean resultado=consultas.BorrarTractor(97);
         assertEquals(respuesta_espareada, resultado);
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
     
     
    

}
