package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private PanelBusqueda panelBusqueda;
    private PanelSidebar panelSidebar;
    private PanelTabla panelTabla;
    private PanelInferior panelDetalles;

    public VentanaPrincipal() {
        setTitle("Gestión de Empleados");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarComponentes();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void inicializarComponentes() {
        panelBusqueda = new PanelBusqueda();
        add(panelBusqueda, BorderLayout.NORTH);

        panelSidebar = new PanelSidebar();
        add(panelSidebar, BorderLayout.WEST);

        panelTabla = new PanelTabla();
        add(panelTabla, BorderLayout.CENTER);

        panelDetalles = new PanelInferior();
        add(panelDetalles, BorderLayout.SOUTH);
    }
}
