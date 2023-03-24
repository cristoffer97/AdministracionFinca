/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Vista.*;
import Modelo.Cuadrillas;
import Modelo.Trabajadores;
import controlador.ConsultasCuadrillas;
import controlador.ConsultasMYSQL;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristoffer
 */
public class Gestion_Cuadrillas extends javax.swing.JFrame {

    private static String nombre;
    private static int codigo;
    private ArrayList<Cuadrillas> listaCuadrilla = new ArrayList<Cuadrillas>();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    ConsultasMYSQL consultas1 = new ConsultasMYSQL();
    ConsultasCuadrillas consultas = new ConsultasCuadrillas();

    public Gestion_Cuadrillas() {
        iniciarFormulario();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        comprobarCuadrillas();
        agregarModeloTabla();
        agregarCuadrillas();
        initComponents();
    }

    private void iniciarFormulario() {
        setSize(400, 400);
        setTitle("Gestion de las Cuadrillas");
        setLocationRelativeTo(null);
        setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCodigo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        cajaCodigo = new javax.swing.JTextField();
        cajaNombre = new javax.swing.JTextField();
        btnoIngresar = new javax.swing.JButton();
        btnoBuscar = new javax.swing.JButton();
        btnobORRAR = new javax.swing.JButton();
        btnoCerrar = new javax.swing.JButton();
        btnoLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Cuadrillas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("GESTION DE LAS CUADRILLAS");

        ListSelectionListener oyenteSeleccion=new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(e.getValueIsAdjusting()){
                    int filaSeleccionada=jTable1.getSelectedRow();
                    String codigo=(String) modeloTabla.getValueAt(filaSeleccionada, 0);
                    String nombre=(String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    String apellido=(String) modeloTabla.getValueAt(filaSeleccionada, 2);

                    cajaCodigo.setText(codigo);
                    cajaNombre.setText(nombre);

                }

            }
        };
        jTable1.getSelectionModel().addListSelectionListener(oyenteSeleccion);

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTable1);

        txtCodigo.setBackground(new java.awt.Color(0, 0, 0));
        txtCodigo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigo.setText("Codigo");

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setText("Nombre");

        btnoIngresar.setBackground(new java.awt.Color(0, 0, 0));
        btnoIngresar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnoIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnoIngresar.setText("Crear");
        btnoIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoIngresarActionPerformed(evt);
            }
        });

        btnoBuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnoBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnoBuscar.setText("Buscar");
        btnoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoBuscarActionPerformed(evt);
            }
        });

        btnobORRAR.setBackground(new java.awt.Color(0, 0, 0));
        btnobORRAR.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnobORRAR.setForeground(new java.awt.Color(255, 255, 255));
        btnobORRAR.setText("Borrar");
        btnobORRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnobORRARActionPerformed(evt);
            }
        });

        btnoCerrar.setBackground(new java.awt.Color(0, 0, 0));
        btnoCerrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnoCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnoCerrar.setText("Cerrar");
        btnoCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoCerrarActionPerformed(evt);
            }
        });

        btnoLimpiar.setBackground(new java.awt.Color(0, 0, 0));
        btnoLimpiar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnoLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnoLimpiar.setText("Limpiar");
        btnoLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnoLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnoIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addComponent(txtNombre)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnobORRAR)
                            .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnoBuscar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(btnoCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo)
                    .addComponent(txtNombre)
                    .addComponent(cajaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnoIngresar)
                    .addComponent(btnoBuscar))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnoLimpiar)
                    .addComponent(btnobORRAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnoCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Con este metodo Guardamos la cuadrilla
     *
     * @param evt
     */
    private void btnoIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoIngresarActionPerformed

        String cod = cajaCodigo.getText();
        codigo = Integer.parseInt(cod);
        nombre = cajaNombre.getText();

        if (consultas.InsertarCuadrillas(codigo, nombre) == true) {
            JOptionPane.showMessageDialog(null, "Se ha guardado los datos");
            LimpiarTabla();
            ActualizarTabla();
        }


    }//GEN-LAST:event_btnoIngresarActionPerformed
    /**
     * Con este metodo borramos la cuadrilla
     *
     * @param evt
     */
    private void btnobORRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnobORRARActionPerformed
        String cod = cajaCodigo.getText();
        codigo = Integer.parseInt(cod);
        if (consultas.borraCuadrilla(codigo) == true) {
            JOptionPane.showMessageDialog(null, "Se ha borrado la cuadrilla");
            LimpiarTabla();
            ActualizarTabla();
//        agregarCuadrilla();  
        }
    }//GEN-LAST:event_btnobORRARActionPerformed
    /**
     * Con este metodo Cerramos la ventana
     *
     * @param evt
     */
    private void btnoCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoCerrarActionPerformed
        VentanaTareas vt = new VentanaTareas();
        vt.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnoCerrarActionPerformed
    /**
     * Con este metodo limpiamos los campos despues de hacer alguna tarea
     *
     * @param evt
     */
    private void btnoLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoLimpiarActionPerformed
        cajaCodigo.setText("");
        cajaNombre.setText("");
    }//GEN-LAST:event_btnoLimpiarActionPerformed
    /**
     * Con este metodo realizamos la busqueda de la cuadrilla solicitado
     *
     * @param evt
     */
    private void btnoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoBuscarActionPerformed
        String cod = cajaCodigo.getText();
        codigo = Integer.parseInt(cod);
        Cuadrillas c = consultas.buscarCuadrilla(codigo);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Cuadrilla no registrada");
        } else {
            cajaNombre.setText(c.getNombreCuadrilla());
        }
    }//GEN-LAST:event_btnoBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gestion_Cuadrillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Cuadrillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Cuadrillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Cuadrillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Cuadrillas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnoBuscar;
    private javax.swing.JButton btnoCerrar;
    private javax.swing.JButton btnoIngresar;
    private javax.swing.JButton btnoLimpiar;
    private javax.swing.JButton btnobORRAR;
    private javax.swing.JTextField cajaCodigo;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables

    /**
     * Sacamos todas las cuadrillas de nuestra BD
     */
    private void comprobarCuadrillas() {
        listaCuadrilla = consultas1.comprobarCuadrillas();

    }

    private void agregarModeloTabla() {

        modeloTabla.addColumn("CodCuadrilla");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad de Personas");
    }

    /**
     * Agregamos los registros de nuestro array list a la cuadrilla
     */
    private void agregarCuadrillas() {

        for (Cuadrillas c : listaCuadrilla) {

            int cant = consultas1.obtenerCantidadPersonas(c.getCodigoCuadrilla());
            String cantidad = String.valueOf(cant);
            int cod_Trabajador = c.getCodigoCuadrilla();
            String codigo = String.valueOf(cod_Trabajador);
            nombre = c.getNombreCuadrilla();
            String[] jornal = {codigo, nombre, cantidad};
            modeloTabla.addRow(jornal);
        }
    }

    private void ActualizarTabla() {
        comprobarCuadrillas();
        agregarCuadrillas();
    }

    public void LimpiarTabla() {
        int lon = modeloTabla.getRowCount();
        for (int i = 0; i < lon; i++) {
            modeloTabla.removeRow(0);

        }
    }
}
