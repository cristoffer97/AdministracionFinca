/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import controlador.ConsultasMYSQL;

/**
 *
 * @author Cristoffer
 */
public class testAccessoAlSistema {
    
    
    
       @Test
     public void testValidarAccesoAlSistema(){
        String nombre="Cristof";
        int codigo=4229;
        //instance=new Cartelera();        
        boolean respuesta_espareada=true;
        ConsultasMYSQL consultas =new ConsultasMYSQL();       
         boolean resultado=consultas.validardatos(nombre, codigo);
         assertEquals(respuesta_espareada, resultado);
        //En caso de que no funcione el test
        fail("El caso de prueba es un prototipo");
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
