package co.edu.unbosque.view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Vista {
	private VentanaPrincipal ventanaPrincipal;
	private VentanaEmpleado ventanaEmpleado;
	
	public Vista() {
		super();
		ventanaPrincipal = new VentanaPrincipal();
		ventanaEmpleado = new VentanaEmpleado();
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	public VentanaEmpleado getVentanaEmpleado() {
		return ventanaEmpleado;
	}
	public void setVentanaEmpleado(VentanaEmpleado ventanaEmpleado) {
		this.ventanaEmpleado = ventanaEmpleado;
	}
	
   
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE, UIManager.getIcon("OptionPane.informationIcon"));
    }

    public void mostrarMensajeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE, UIManager.getIcon("OptionPane.warningIcon"));
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE, UIManager.getIcon("OptionPane.errorIcon"));
    }

    public int mostrarMensajeConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, UIManager.getIcon("OptionPane.questionIcon"));
    }
}
