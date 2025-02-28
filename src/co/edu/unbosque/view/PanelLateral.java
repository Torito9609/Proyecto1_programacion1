package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelLateral extends JPanel {

    private JButton gestionarButton, inicioButton;

    public PanelLateral() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  
        setBackground(Color.LIGHT_GRAY);

        inicializarComponentes();
    }
    
    public void inicializarComponentes() {
        JLabel logoLabel = new JLabel("Logo de la empresa");

        inicioButton = new JButton("Inicio");
        inicioButton.setActionCommand("INICIO");
        gestionarButton = new JButton("Gestionar empleados");
        gestionarButton.setActionCommand("GESTIONAR");

        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inicioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        gestionarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(logoLabel);
        add(Box.createRigidArea(new Dimension(0, 20))); 
        add(inicioButton);
        add(Box.createRigidArea(new Dimension(0, 10))); 
        add(gestionarButton);
    }

	public JButton getGestionarButton() {
		return gestionarButton;
	}

	public void setGestionarButton(JButton gestionarButton) {
		this.gestionarButton = gestionarButton;
	}

	public JButton getInicioButton() {
		return inicioButton;
	}

	public void setInicioButton(JButton inicioButton) {
		this.inicioButton = inicioButton;
	}
    
    
}
