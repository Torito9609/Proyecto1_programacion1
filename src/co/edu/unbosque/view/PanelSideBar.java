package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelSidebar extends JPanel {

    private JButton gestionarButton, inicioButton;

    public PanelSidebar() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // BoxLayout sencillo en eje Y
        setBackground(Color.LIGHT_GRAY);

        inicializarComponentes();
    }
    
    public void inicializarComponentes() {
        JLabel logoLabel = new JLabel("Logo de la empresa");

        inicioButton = new JButton("Inicio");
        gestionarButton = new JButton("Gestionar empleados");

        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inicioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        gestionarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(logoLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio vertical entre logo y botón
        add(inicioButton);
        add(Box.createRigidArea(new Dimension(0, 10)));  // Espacio vertical entre botones
        add(gestionarButton);
    }
}
