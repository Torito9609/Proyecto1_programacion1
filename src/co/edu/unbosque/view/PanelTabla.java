package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelTabla extends JPanel {

    private JTable tablaEmpleados;

    public PanelTabla() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  

        inicializarComponentes(); 
    }
    
    public void inicializarComponentes() {
    	String[] columnas = {"Cédula", "Nombres y Apellidos", "Correo", "Teléfono", "Tipo de empleado", "Género"};
        tablaEmpleados = new JTable(new Object[][]{}, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);

        add(scrollPane, BorderLayout.CENTER); 
    }
}
