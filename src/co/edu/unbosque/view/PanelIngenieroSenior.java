package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelIngenieroSenior extends JPanel {

    private JTextField numeroVentasField;

    public PanelIngenieroSenior() {
    	setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        add(new JLabel("Número de Ventas:"));
        numeroVentasField = new JTextField(20);
        add(numeroVentasField);
    }

	public JTextField getNumeroVentasField() {
		return numeroVentasField;
	}

	public void setNumeroVentasField(JTextField numeroVentasField) {
		this.numeroVentasField = numeroVentasField;
	}

    
}
