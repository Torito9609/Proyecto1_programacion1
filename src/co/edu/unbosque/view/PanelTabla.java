package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Empleado;

public class PanelTabla extends JPanel {

    private JTable tablaEmpleados;
    private DefaultTableModel modeloTabla;

    public PanelTabla() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inicializarComponentes();
    }

    public void inicializarComponentes() {
        String[] columnas = {"Cédula", "Nombres y Apellidos", "Correo", "Teléfono", "Tipo de empleado", "Género"};
        
        modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        tablaEmpleados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void actualizarTabla(List<Empleado> empleados) {
        modeloTabla.setRowCount(0);

        for (Empleado empleado : empleados) {
            Object[] fila = {
                empleado.getCedula(),
                empleado.getNombre() + " " + empleado.getApellidos(),
                empleado.getCorreoInstitucional(),
                empleado.getTelefono(),
                empleado.getTipoEmpleado(),
                empleado.getGenero()
            };
            modeloTabla.addRow(fila);
        }
    }

    public JTable getTablaEmpleados() {
        return tablaEmpleados;
    }
}
