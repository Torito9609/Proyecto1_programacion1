package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {

    private JButton crearButton;
    private JButton editarButton;
    private JTextArea infoEmpleado;
    private JButton eliminarButton;

    public PanelInferior() {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10)); 
        setBackground(Color.LIGHT_GRAY);

        inicializarComponentes();
    }
    
    public void inicializarComponentes() {
    	crearButton = new JButton("Crear nuevo empleado");
    	crearButton.setActionCommand("CREAR_EMPLEADO");
        add(crearButton);
        
        editarButton = new JButton("Editar empleado");
        editarButton.setActionCommand("EDITAR_EMPLEADO");
        add(editarButton);
        
        eliminarButton = new JButton("Eliminar empleado");
        eliminarButton.setActionCommand("ELIMINAR_EMPLEADO");
        add(eliminarButton);
        
        infoEmpleado = new JTextArea(10, 55);
        infoEmpleado.setEditable(false); 
        infoEmpleado.setLineWrap(true);
        infoEmpleado.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(infoEmpleado);
        add(scrollPane, BorderLayout.CENTER);
    }

	public JButton getCrearButton() {
		return crearButton;
	}

	public void setCrearButton(JButton crearButton) {
		this.crearButton = crearButton;
	}

	public JButton getEditarButton() {
		return editarButton;
	}

	public void setEditarButton(JButton editarButton) {
		this.editarButton = editarButton;
	}

	public JTextArea getInfoEmpleado() {
		return infoEmpleado;
	}

	public void setInfoEmpleado(JTextArea infoEmpleado) {
		this.infoEmpleado = infoEmpleado;
	}

	public JButton getEliminarButton() {
		return eliminarButton;
	}

	public void setEliminarButton(JButton eliminarButton) {
		this.eliminarButton = eliminarButton;
	}
	
	
    
}
