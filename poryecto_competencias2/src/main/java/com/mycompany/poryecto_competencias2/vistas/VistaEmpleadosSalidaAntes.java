import com.mycompany.poryecto_competencias2.Controlador.ControladorReportesDAO;
import com.mycompany.poryecto_competencias2.modelos.ReporteSalidaModelo; // Tu modelo actual
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.sql.Time;

public class VistaEmpleadosSalidaAntes extends javax.swing.JFrame {

    public VistaEmpleadosSalidaAntes() {
        initComponents();

        // Acción del botón Buscar
        btnBuscar.addActionListener(e -> llenarTabla());
    }

    private void llenarTabla() {
        try {
            // Obtener fecha del textfield
            String fechaTexto = tfBuscarPorFechaa.getText().trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date fechaUtil = sdf.parse(fechaTexto);
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

            // Llamar al controlador
            ControladorReportesDAO controlador = new ControladorReportesDAO();
            List<ReporteSalidaModelo> lista = controlador.mostrarSalidas(fechaSQL, null); // Hora límite no necesaria, filtraremos aquí

            // Hora límite 17:30
            Time horaLimite = Time.valueOf("17:30:00");

            // Configurar tabla
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0); // limpiar tabla

            // Recorrer la lista y filtrar por hora de salida
            for (ReporteSalidaModelo salida : lista) {
                if (salida.getHoraSalida().before(horaLimite)) {
                    modelo.addRow(new Object[]{
                        salida.getNombre(),
                        salida.getApellidos(),
                        salida.getHoraSalida()
                    });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Error al buscar: " + ex.getMessage());
        }
    }

    private void btnVolverAVistaMenuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {                                                            
        VistaMenuAdmin vistaMenuAdmin = new VistaMenuAdmin();
        vistaMenuAdmin.setVisible(true);
        vistaMenuAdmin.setLocationRelativeTo(null); 
    }      
}
