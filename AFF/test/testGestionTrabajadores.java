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
import controlador.ConsultasTrabajadores;

/**
 *
 * @author Cristoffer
 */
public class testGestionTrabajadores {
    
    public testGestionTrabajadores() {
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
     public void testModificarTrabajador(){
        //instance=new Cartelera();        
        boolean respuesta_espareada=true;
        ConsultasTrabajadores consultas =new ConsultasTrabajadores();       
         boolean resultado=consultas.actualizarDatosdeTrabajador(1202, "MARY", "MUÑOZ",123586934 ,1, true, 4);
         assertEquals(respuesta_espareada, resultado);
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
     /**
     * Prueba de Ingreso de trabajador
     */
     @Test
     public void testIngresarTrabajador(){
        //instance=new Cartelera();        
        boolean respuesta_espareada=true;
        ConsultasTrabajadores consultas =new ConsultasTrabajadores();       
         boolean resultado=consultas.IngresarTrabajador(4510, "MARY", "MUÑOZ",123586934 ,1, true, 4);
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
        ConsultasTrabajadores consultas =new ConsultasTrabajadores();       
         boolean resultado=consultas.BorrarTrabajador(1202);
         assertEquals(respuesta_espareada, resultado);
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
    

}
