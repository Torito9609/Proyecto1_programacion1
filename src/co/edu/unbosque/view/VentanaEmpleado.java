package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaEmpleado extends JFrame {

    private PanelEmpleadoSuperior panelSuperior;
    private PanelEmpleadoDinamico panelDinamico;

    public VentanaEmpleado() {
        setTitle("Editar/Crear Empleado");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSuperior = new PanelEmpleadoSuperior();
        panelDinamico = new PanelEmpleadoDinamico();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDinamico, BorderLayout.CENTER);

        panelSuperior.getTipoEmpleadoComboBox().addActionListener(e -> actualizarPanelDinamico());
    }

    private void actualizarPanelDinamico() {
        String tipoEmpleado = (String) panelSuperior.getTipoEmpleadoComboBox().getSelectedItem();
        JPanel nuevoPanel;

        switch (tipoEmpleado) {
            case "Empleado a Comisión":
                nuevoPanel = new PanelEmpleadoComision();
                break;
            case "Ingeniero Junior":
                nuevoPanel = new PanelIngenieroJunior();
                break;
            case "Ingeniero Senior":
                nuevoPanel = new PanelIngenieroSenior();
                break;
            case "Técnico":
                nuevoPanel = new PanelTecnico();
                break;
            default:
                nuevoPanel = new JPanel();
        }

        panelDinamico.mostrarPanelEmpleado(nuevoPanel);
    }
}
