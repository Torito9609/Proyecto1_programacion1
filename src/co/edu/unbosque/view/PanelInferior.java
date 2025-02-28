package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {

    private JButton crearButton;
    private JButton editarButton;

    public PanelInferior() {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10)); 
        setBackground(Color.LIGHT_GRAY);

        inicializarComponentes();
    }
    
    public void inicializarComponentes() {
    	crearButton = new JButton("Crear nuevo empleado");
        add(crearButton);
        
        editarButton = new JButton("Editar empleado");
        add(editarButton);
    }
}
