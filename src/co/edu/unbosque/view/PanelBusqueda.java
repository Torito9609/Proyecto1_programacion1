package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelBusqueda extends JPanel {

    private JComboBox<String> buscarPorComboBox, tipoEmpleadoComboBox;
    private JButton buscarButton;
    private JTextField buscarTextField;
    private JLabel buscarPor, filtrar;
    
    public PanelBusqueda() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));  
        setBackground(Color.LIGHT_GRAY);
        
        inicializarComponentes();
    }
    
    public void inicializarComponentes() {
    	buscarPorComboBox = new JComboBox<>(new String[]{"Nombre", "Cédula", "Correo"});
        buscarTextField = new JTextField(20);
        buscarButton = new JButton("Buscar");
        tipoEmpleadoComboBox = new JComboBox<>(new String[]{"Ingeniero Junior", "Ingeniero Senior", "Técnico", "Empleado a Comisión"});
        buscarPor = new JLabel("Buscar por:");
        filtrar = new JLabel("Filtrar por:");
        
        add(buscarPor);
        add(buscarPorComboBox);
        add(buscarTextField);
        add(buscarButton);
        add(filtrar);
        add(tipoEmpleadoComboBox);
    }
}
