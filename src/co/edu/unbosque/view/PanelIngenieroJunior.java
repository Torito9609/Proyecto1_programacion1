package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelIngenieroJunior extends JPanel {

    private JComboBox<String> nivelComboBox;

    public PanelIngenieroJunior() {
    	setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        add(new JLabel("Nivel:"));
        nivelComboBox = new JComboBox<>(new String[]{"Seleccionar", "Nivel 1", "Nivel 2", "Nivel 3"});
        nivelComboBox.setActionCommand("NIVEL_JUNIOR");
        add(nivelComboBox);
    }

	public JComboBox<String> getNivelComboBox() {
		return nivelComboBox;
	}

	public void setNivelComboBox(JComboBox<String> nivelComboBox) {
		this.nivelComboBox = nivelComboBox;
	}
    
}
