package com.mycompany.poryecto_competencias2.vistas;

import com.mycompany.poryecto_competencias2.Controlador.ControladorReportesDAO;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaEmpleadosSalidaAntes extends javax.swing.JFrame {

    public VistaEmpleadosSalidaAntes() {
        initComponents();
        cargarTabla(); // 👉 llenamos la tabla al iniciar
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleadosSalida = new javax.swing.JTable();
        btnVolverAVistaMenuEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaEmpleadosSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Nombre", "Apellido", "Fecha", "Hora de salida"}
        ));
        jScrollPane1.setViewportView(tablaEmpleadosSalida);

        btnVolverAVistaMenuEmpleado.setText("Volver");
        btnVolverAVistaMenuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAVistaMenuEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolverAVistaMenuEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 604, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolverAVistaMenuEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void btnVolverAVistaMenuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {
        VistaMenuAdmin vistaMenuAdmin = new VistaMenuAdmin();
        vistaMenuAdmin.setVisible(true);
        vistaMenuAdmin.setLocationRelativeTo(null);
        this.dispose();
    }

    // 👉 Método para cargar la tabla usando el controlador SIN modificarlo
    private void cargarTabla() {
        ControladorReportesDAO controlador = new ControladorReportesDAO();

        // Ejemplo: usar fecha actual y hora límite fija
        Date fechaHoy = new java.sql.Date(System.currentTimeMillis());
        Time horaLimite = java.sql.Time.valueOf("17:00:00");

        List<ReporteSalidaModelo> salidas = controlador.mostrarSalidas(fechaHoy, horaLimite);

        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleadosSalida.getModel();
        modelo.setRowCount(0); // limpiar antes de cargar

        for (ReporteSalidaModelo s : salidas) {
            modelo.addRow(new Object[]{
                s.getNombre(),
                s.getApellidos(),
                s.getFecha(),
                s.getHoraSalida()
            });
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEmpleadosSalidaAntes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnVolverAVistaMenuEmpleado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleadosSalida;
    // End of variables declaration
}

