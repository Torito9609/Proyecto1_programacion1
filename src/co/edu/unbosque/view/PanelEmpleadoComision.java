package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelEmpleadoComision extends JPanel {

    private JTextField clientesCaptadosField;

    public PanelEmpleadoComision() {
    	setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        add(new JLabel("Clientes Captados:"));
        clientesCaptadosField = new JTextField(20);
        add(clientesCaptadosField);
    }

	public JTextField getClientesCaptadosField() {
		return clientesCaptadosField;
	}

	public void setClientesCaptadosField(JTextField clientesCaptadosField) {
		this.clientesCaptadosField = clientesCaptadosField;
	}
  
}
