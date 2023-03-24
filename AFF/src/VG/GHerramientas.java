
package VG;

import Modelo.H_CONECTADA;
import Modelo.Tractor;
import controlador.ConsultasMYSQL;
import controlador.ConsultasTractor;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristoffer
 */
public class GHerramientas extends javax.swing.JPanel {
 private static int codtrabaj;
    private static String matricula;
    private DefaultComboBoxModel modelo = new DefaultComboBoxModel<>();
    private ArrayList<H_CONECTADA> listaHerramientas = new ArrayList<H_CONECTADA>();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private static ArrayList<Tractor> listaTractor = new ArrayList<>();
    ConsultasMYSQL consultas1 = new ConsultasMYSQL();
    ConsultasTractor consulta = new ConsultasTractor();
    private String Columnas[] = {"Codigo de tractor", "Matricula", "Herramienta"};

    public GHerramientas() {
        //iniciarFormulario();
        initComponents();
        //Metodos Para El insertar
        comprobarHerramientas();
        jcomboHerramienta.addItem("Selecciona una herramienta");
        llenarModeloComboBox();
        //Metodo Para actualizar
        asignarColumnas();
        actualizar_Tabla();

    }

    private void llenarModeloComboBox() {

        for (H_CONECTADA h : listaHerramientas) {
            modelo.addElement(h);

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        etiquetaCodigo = new javax.swing.JLabel();
        cajaCodigo = new javax.swing.JTextField();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaCuadrilla = new javax.swing.JLabel();
        cajaMatricula = new javax.swing.JTextField();
        btnoInsertar = new javax.swing.JButton();
        btnoModificar = new javax.swing.JButton();
        btnoBuscar = new javax.swing.JButton();
        btnoBaja = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jcomboHerramienta = new javax.swing.JComboBox<>();
        btnoLimpiar = new javax.swing.JButton();
        etiquetaCodigo1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 0));

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Gestion de Herramientas");

        etiquetaCodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etiquetaCodigo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaCodigo.setText("CodigoTractor");

        cajaCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCodigoActionPerformed(evt);
            }
        });

        etiquetaNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etiquetaNombre.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaNombre.setText("Matricula");

        etiquetaCuadrilla.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etiquetaCuadrilla.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaCuadrilla.setText("Herramienta");

        cajaMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaMatriculaActionPerformed(evt);
            }
        });

        btnoInsertar.setBackground(new java.awt.Color(0, 0, 0));
        btnoInsertar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnoInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnoInsertar.setText("Insertar");
        btnoInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoInsertarActionPerformed(evt);
            }
        });

        btnoModificar.setBackground(new java.awt.Color(0, 0, 0));
        btnoModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnoModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnoModificar.setText("Modificar");
        btnoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoModificarActionPerformed(evt);
            }
        });

        btnoBuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnoBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnoBuscar.setText("Buscar");
        btnoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoBuscarActionPerformed(evt);
            }
        });

        btnoBaja.setBackground(new java.awt.Color(0, 0, 0));
        btnoBaja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnoBaja.setForeground(new java.awt.Color(255, 255, 255));
        btnoBaja.setText("Baja");
        btnoBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoBajaActionPerformed(evt);
            }
        });

        jTable1.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTable1);

        jcomboHerramienta.setModel(modelo);

        btnoLimpiar.setBackground(new java.awt.Color(0, 0, 0));
        btnoLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnoLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnoLimpiar.setText("Limpiar");
        btnoLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoLimpiarActionPerformed(evt);
            }
        });

        etiquetaCodigo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etiquetaCodigo1.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaCodigo1.setText("LISTA DE TRACTORES ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnoInsertar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etiquetaCodigo)
                                        .addComponent(etiquetaCuadrilla)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jcomboHerramienta, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cajaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(etiquetaNombre)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cajaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnoModificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnoBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnoBaja)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnoLimpiar)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaCodigo1)
                        .addGap(0, 374, Short.MAX_VALUE))))
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cajaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiquetaCodigo)
                        .addComponent(etiquetaNombre)
                        .addComponent(cajaMatricula)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcomboHerramienta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCuadrilla))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnoInsertar)
                    .addComponent(btnoModificar)
                    .addComponent(btnoBuscar)
                    .addComponent(btnoBaja)
                    .addComponent(btnoLimpiar))
                .addGap(18, 18, 18)
                .addComponent(etiquetaCodigo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cajaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCodigoActionPerformed

    private void cajaMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaMatriculaActionPerformed

    private void btnoInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoInsertarActionPerformed

        int herramienta = 0;
        String codigo = cajaCodigo.getText();
        codtrabaj = Integer.parseInt(codigo);
        matricula = cajaMatricula.getText();
        String cua = (String) jcomboHerramienta.getSelectedItem().toString();
        for (H_CONECTADA listaHerramienta : listaHerramientas) {
            if (cua.equals(listaHerramienta.toString())) {
                herramienta = listaHerramienta.getId();
            }
        }

        consulta.InsertarTractor(codtrabaj, matricula, herramienta);
        actualizar_Tabla();

    }//GEN-LAST:event_btnoInsertarActionPerformed

    private void btnoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoModificarActionPerformed
        int herramienta = 0;
        String codigo = cajaCodigo.getText();
        codtrabaj = Integer.parseInt(codigo);
        matricula = cajaMatricula.getText();
        String cua = (String) jcomboHerramienta.getSelectedItem().toString();
        for (H_CONECTADA listaHerramienta : listaHerramientas) {
            if (cua.equals(listaHerramienta.toString())) {
                herramienta = listaHerramienta.getId();
            }
        }

        consulta.actualizarTractor(codtrabaj, matricula, herramienta);
        actualizar_Tabla();
    }//GEN-LAST:event_btnoModificarActionPerformed

    private void btnoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoBuscarActionPerformed

        String codigo = cajaCodigo.getText();
        codtrabaj = Integer.parseInt(codigo);

        for (Tractor tractor : listaTractor) {
            if(tractor.getCod_tractor()==codtrabaj){
                int codigoHerramienta=tractor.getHerramienta().getId();
                cajaCodigo.setText(codigo);
                cajaMatricula.setText(tractor.getMatricula());

            }

        }

    }//GEN-LAST:event_btnoBuscarActionPerformed

    private void btnoBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoBajaActionPerformed
        String codigo = cajaCodigo.getText();
        int Cod_Tractor = Integer.parseInt(codigo);
        consulta.BorrarTractor(Cod_Tractor);
        actualizar_Tabla();
    }//GEN-LAST:event_btnoBajaActionPerformed

    private void btnoLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoLimpiarActionPerformed
        cajaCodigo.setText("");
        cajaMatricula.setText("");
        jcomboHerramienta.setSelectedIndex(0);
    }//GEN-LAST:event_btnoLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnoBaja;
    private javax.swing.JButton btnoBuscar;
    private javax.swing.JButton btnoInsertar;
    private javax.swing.JButton btnoLimpiar;
    private javax.swing.JButton btnoModificar;
    private javax.swing.JTextField cajaCodigo;
    private javax.swing.JTextField cajaMatricula;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaCodigo1;
    private javax.swing.JLabel etiquetaCuadrilla;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcomboHerramienta;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtenemos en un array list todas las herremaientas disponibles de nuestra
     * base de datos
     */
    private void comprobarHerramientas() {
        listaHerramientas = consultas1.comprobarHerramientas();
    }

    /**
     * Sacamos todos los tractores de nuestra BD
     */
    private void sacarTractoresBD() {
        listaTractor = consultas1.sacarTractores();

    }

    /**
     * Agregamos los registros que hemos obtenido de nuestra BD a nuestra tabla
     */
    private void agregarModeloTabla() {
        LimpiarTabla();

        for (Tractor tractor : listaTractor) {
            int cod = tractor.getCod_tractor();
            String codigo = String.valueOf(cod);
            String matricula = tractor.getMatricula();
            String herramienta = tractor.getHerramienta().getNombre();
            String[] tract = {codigo, matricula, herramienta};
            modeloTabla.addRow(tract);
        }

    }

    /**
     * Cada vez que hagamos una operacion se nos limpiara la tabla
     */
    public void LimpiarTabla() {
        int lon = modeloTabla.getRowCount();
        for (int i = 0; i < lon; i++) {
            modeloTabla.removeRow(0);

        }
    }

    /**
     * Asiganmos el nombre de las columnas a nuestra tabal
     */
    private void asignarColumnas() {
        for (int i = 0; i < Columnas.length; i++) {
            modeloTabla.addColumn(Columnas[i]);
        }
    }

    /**
     * Metodo que nos actualiza la tabla de los tractores
     */
    private void actualizar_Tabla() {
        sacarTractoresBD();
        agregarModeloTabla();
    }
}
