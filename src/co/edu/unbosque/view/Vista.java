package co.edu.unbosque.view;

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
	
}
