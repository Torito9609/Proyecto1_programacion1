package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelEmpleadoDinamico extends JPanel {

    private JPanel panelActual;

    public PanelEmpleadoDinamico() {
        setLayout(new CardLayout());
    }

    public void mostrarPanelEmpleado(JPanel nuevoPanel) {
        if (panelActual != null) {
            remove(panelActual);
        }
        panelActual = nuevoPanel;
        add(panelActual);
        revalidate();
        repaint();
    }

	public JPanel getPanelActual() {
		return panelActual;
	}

	public void setPanelActual(JPanel panelActual) {
		this.panelActual = panelActual;
	}
    
}
