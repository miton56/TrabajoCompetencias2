package com.mycompany.poryecto_competencias2.vistas;

import com.mycompany.poryecto_competencias2.Controlador.ControladorReportesDAO;
import com.mycompany.poryecto_competencias2.modelos.ReporteAtrasoModelo;
import java.sql.Date;
import java.sql.Time;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marti0
 */
public class VistaEmpleadosAtrasados extends javax.swing.JFrame {

    public VistaEmpleadosAtrasados() {
        initComponents();
        // Conectar el botón Buscar al método llenarCampos
        btnBuscar.addActionListener(e -> llenarCampos());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAtrasados = new javax.swing.JTable();
        btnVolverAVistaMenuEmpleado = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        tfBuscarPorFechaa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaAtrasados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Empleado", "Hora de atraso", "Dia de atraso"
            }
        ));
        jScrollPane1.setViewportView(TablaAtrasados);

        btnVolverAVistaMenuEmpleado.setText("Volver");
        btnVolverAVistaMenuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAVistaMenuEmpleadoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tfBuscarPorFechaa.setText("19-06-2025"); // ejemplo

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolverAVistaMenuEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 604, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(tfBuscarPorFechaa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBuscar)
                .addContainerGap(500, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscarPorFechaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolverAVistaMenuEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
<<<<<<< HEAD
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverAVistaMenuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAVistaMenuEmpleadoActionPerformed
    
    // Crear instancia de la nueva ventana
    VistaMenuAdmin vistaMenuAdmin = new VistaMenuAdmin();
    
    // Mostrar la ventana
    vistaMenuAdmin.setVisible(true);
    
    // Opcional: centrar la ventana
    vistaMenuAdmin.setLocationRelativeTo(null);        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverAVistaMenuEmpleadoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       
        Date fecha = java.sql.Date.valueOf(tfBuscarPorFechaa.getText());
        
        Time hora = java.sql.Time.valueOf("09:30:00");

        llenarCampos(fecha, hora);
        
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaEmpleadosAtrasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleadosAtrasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleadosAtrasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleadosAtrasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEmpleadosAtrasados().setVisible(true);
            }
        });
=======
>>>>>>> 32ffafc7759b0903eaca7bbcf05b17c2d410f3ff
    }

    private void btnVolverAVistaMenuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {
        VistaMenuAdmin vistaMenuAdmin = new VistaMenuAdmin();
        vistaMenuAdmin.setVisible(true);
        vistaMenuAdmin.setLocationRelativeTo(null);
    }

    // --- ESTE MÉTODO ES EL IMPORTANTE ---
    private void llenarCampos() {
        try {
            // 1. Tomar la fecha del JTextField
            String fechaTexto = tfBuscarPorFechaa.getText().trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date parsed = sdf.parse(fechaTexto);
            Date fechaSQL = new Date(parsed.getTime());

            // 2. Definir la hora límite fija 09:30:00
            Time horaLimite = Time.valueOf("09:30:00");

            // 3. Consultar atrasados
            ControladorReportesDAO cont = new ControladorReportesDAO();
            List<ReporteAtrasoModelo> atrasos = cont.mostrarAtrasados(fechaSQL, horaLimite);

            // 4. Llenar tabla
            DefaultTableModel modelo = (DefaultTableModel) TablaAtrasados.getModel();
            modelo.setRowCount(0);
            for (ReporteAtrasoModelo atraso : atrasos) {
                modelo.addRow(new Object[]{
                    atraso.getNombre(),
                    atraso.getHoraEntrada(),
                    atraso.getFecha()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: formato de fecha incorrecto (use dd-MM-yyyy)");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VistaEmpleadosAtrasados().setVisible(true));
    }

    // Variables
    private javax.swing.JTable TablaAtrasados;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolverAVistaMenuEmpleado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfBuscarPorFechaa;
<<<<<<< HEAD
    // End of variables declaration//GEN-END:variables

    private void llenarCampos(Date fecha, Time hora){

        ControladorReportesDAO cont = new ControladorReportesDAO();

        List<ReporteAtrasoModelo> atrasos = cont.mostrarAtrasados(fecha, hora);

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        for(ReporteAtrasoModelo reporte : atrasos){

            modelo.addRow(new Object[]{
                reporte.getNombre(),
                reporte.getHoraEntrada(),
                reporte.getFecha()
            });

        }
    }
=======
>>>>>>> 32ffafc7759b0903eaca7bbcf05b17c2d410f3ff
}

