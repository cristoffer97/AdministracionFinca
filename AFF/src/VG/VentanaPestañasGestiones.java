package VG;

import javax.swing.*;
import java.awt.*;
import controlador.*;
import java.awt.event.*;

/**
 *
 * @author Cristoffer
 */
public class VentanaPestañasGestiones extends JFrame implements Configuracion{
 

    public VentanaPestañasGestiones() {
        //colocarMenu();
        // colocarMenuItem();
        CrearVentanaPestañaGestiones();
         
    }
    
 


    private void CrearVentanaPestañaGestiones() {
        setResizable(false);
        setTitle("Gestiones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 550);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        // Creamos el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Creamos el panel para la primera pestaña
        JPanel panel1 = new JPanel();
        GTrabajador ventana1 = new GTrabajador();
        //ventana1.setSize(900, 600);
        panel1.add(ventana1);
        
        // Creamos el panel para la segunda pestaña
        JPanel panel2 = new JPanel();
        GTractor ventana2 = new GTractor();
        panel2.add(ventana2);
        
        // Creamos el panel para la Tercera pestaña
        JPanel panel3 = new JPanel();
        GCuadrillas ventana3 = new GCuadrillas();
        panel3.add(ventana3);
        
        // Creamos el panel para la cuarta pestaña
        JPanel panel4 = new JPanel();
        GTractor_Tractorista ventana4 = new GTractor_Tractorista();
        panel4.add(ventana4);
        
        // Creamos el panel para la quinta pestaña
        JPanel panel5 = new JPanel();
        GHerramientas ventana5 = new GHerramientas();
        panel5.add(ventana5);
        
        
        // Agregamos los paneles como pestañas en el JTabbedPane
        tabbedPane.addTab("G.trabajadores ", panel1);
        tabbedPane.addTab("G.tractores", panel2);
        tabbedPane.addTab("G.cuadrillas", panel3);
        tabbedPane.addTab("G.cuadrillas", panel4);
        tabbedPane.addTab("G.Herramientas", panel5);

        // Ajustamos el tamaño de la ventana 1 para que se ajuste al tamaño de la pestaña
        

        // Agregamos el JTabbedPane al JFrame
        add(tabbedPane);
    }

    public static void main(String[] args) {
        VentanaPestañasGestiones ventana = new VentanaPestañasGestiones();
        ventana.setVisible(true);
    }
}