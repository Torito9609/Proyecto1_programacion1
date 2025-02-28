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
        setVisible(false);

        panelSuperior = new PanelEmpleadoSuperior();
        panelDinamico = new PanelEmpleadoDinamico();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDinamico, BorderLayout.CENTER);
    }

    public PanelEmpleadoSuperior getPanelSuperior() {
        return panelSuperior;
    }

    public PanelEmpleadoDinamico getPanelDinamico() {
        return panelDinamico;
    }
}
