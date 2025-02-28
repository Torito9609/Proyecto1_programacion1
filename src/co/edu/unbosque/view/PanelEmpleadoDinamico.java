package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelEmpleadoDinamico extends JPanel {

    public PanelEmpleadoDinamico() {
        setLayout(new CardLayout());
    }

    public void mostrarPanel(JPanel nuevoPanel) {
        add(nuevoPanel, "panel");
        revalidate();
        repaint();
    }
}
