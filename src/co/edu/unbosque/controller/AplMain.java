package co.edu.unbosque.controller;

import javax.swing.SwingUtilities;

import co.edu.unbosque.view.VentanaEmpleado;
import co.edu.unbosque.view.VentanaPrincipal;

public class AplMain {

    public static void main(String[] args) {
        // Ejecutar la GUI en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal();  // Instanciar la ventana principal
            	//new VentanaEmpleado();
            }
        });
    }
	/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaEmpleado ventana = new VentanaEmpleado();
            ventana.setVisible(true);
        });
    }*/
}
