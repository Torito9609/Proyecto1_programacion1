package co.edu.unbosque.view;

import javax.swing.*;

public class FabricaPanelEmpleadoDinamico {
    
    public static JPanel crearPanel(String tipoEmpleado) {
        switch (tipoEmpleado) {
            case "Ingeniero Junior":
                return new PanelIngenieroJunior();
            case "Ingeniero Senior":
                return new PanelIngenieroSenior(); 
            case "Técnico":
                return new PanelTecnico(); 
            case "Empleado a Comisión":
                return new PanelEmpleadoComision(); 
            default:
                return new JPanel(); 
        }
    }
}
