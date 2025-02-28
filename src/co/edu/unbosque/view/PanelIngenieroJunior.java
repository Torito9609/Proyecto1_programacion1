package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelIngenieroJunior extends JPanel {

    private JComboBox<String> nivelComboBox;

    public PanelIngenieroJunior() {
    	setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        add(new JLabel("Nivel:"));
        nivelComboBox = new JComboBox<>(new String[]{"Junior 1", "Junior 2", "Junior 3"});
        add(nivelComboBox);
    }
}
