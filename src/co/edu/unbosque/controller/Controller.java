package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.Empresa;
import co.edu.unbosque.view.Vista;

public class Controller implements ActionListener{
	private Empresa empresa;
	private Vista vista;
	
	public Controller() {
		empresa = new Empresa();
		vista = new Vista();
		asignaOyentes();
		reiniciarTabla();
		
		vista.getVentanaPrincipal().getPanelTabla().getTablaEmpleados().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
            int filaSeleccionada = vista.getVentanaPrincipal().getPanelTabla().getTablaEmpleados().getSelectedRow();
	                
            if (filaSeleccionada != -1) {
	                    
                String cedula = vista.getVentanaPrincipal().getPanelTabla().getTablaEmpleados().getValueAt(filaSeleccionada, 0).toString();
                Empleado empleadoSeleccionado = empresa.buscarEmpleadoPorCedula(cedula);
                vista.getVentanaPrincipal().getPanelInferior().getInfoEmpleado().setText(empleadoSeleccionado.toString());
             
            }
        }
    });
}
	
	public void reiniciarTabla() {
		List<Empleado> todosEmpleados = new ArrayList();
		todosEmpleados = empresa.getListaEmpleados();
		vista.getVentanaPrincipal().getPanelTabla().actualizarTabla(todosEmpleados);
	}
	
	public void asignaOyentes() {
		vista.getVentanaPrincipal().getPanelBusqueda().getBuscarButton().addActionListener(this);
		vista.getVentanaPrincipal().getPanelBusqueda().getTipoEmpleadoComboBox().addActionListener(this);
		vista.getVentanaPrincipal().getPanelLateral().getGestionarButton().addActionListener(this);
		vista.getVentanaPrincipal().getPanelLateral().getInicioButton().addActionListener(this);
		vista.getVentanaPrincipal().getPanelInferior().getCrearButton().addActionListener(this);
		vista.getVentanaPrincipal().getPanelInferior().getEditarButton().addActionListener(this);
		vista.getVentanaEmpleado().getPanelSuperior().getTipoEmpleadoComboBox().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("BUSCAR")) {
			String texto = vista.getVentanaPrincipal().getPanelBusqueda().getBuscarTextField().getText().trim();
			int pos = vista.getVentanaPrincipal().getPanelBusqueda().getBuscarPorComboBox().getSelectedIndex();
			String tipoBusqueda = vista.getVentanaPrincipal().getPanelBusqueda().getBuscarPorComboBox().getItemAt(pos);
			
			if(tipoBusqueda == null || tipoBusqueda.isEmpty() || tipoBusqueda.equals("Seleccionar")) {
				JOptionPane.showMessageDialog(
					    null, 
					    "Por favor seleccione un tipo de búsqueda.", 
					    "Error", 
					    JOptionPane.ERROR_MESSAGE
					);
				
			}else if(texto == null || texto.isEmpty()){
				JOptionPane.showMessageDialog(
					    null, 
					    "Por favor ingrese un nombre.", 
					    "Error", 
					    JOptionPane.ERROR_MESSAGE
					);
				
			}else{
				String nombreBuscar = vista.getVentanaPrincipal().getPanelBusqueda().getBuscarTextField().getText();
				List<Empleado> coincidenciasNombre = new ArrayList();
				coincidenciasNombre = empresa.buscarEmpleadoPorNombre(nombreBuscar);
				
				if(coincidenciasNombre.isEmpty()) {
					JOptionPane.showMessageDialog(
						    null, 
						    "No existe empleado con ese nombre.", 
						    "Error", 
						    JOptionPane.WARNING_MESSAGE
						);
					
				}else {
					vista.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidenciasNombre);
				}	
			}
			
		}else if(comando.equals("TIPO")) {
			int pos = vista.getVentanaPrincipal().getPanelBusqueda().getTipoEmpleadoComboBox().getSelectedIndex();
			String opcion = vista.getVentanaPrincipal().getPanelBusqueda().getTipoEmpleadoComboBox().getItemAt(pos).toLowerCase();
			
			
			if(opcion.equals("seleccionar")) {
				reiniciarTabla();
				
			}else {
				List<Empleado> coincidenciasTipo = new ArrayList();
				coincidenciasTipo = empresa.filtrarEmpleadoPorTipo(opcion);
				
				if(coincidenciasTipo.isEmpty()) {
					JOptionPane.showMessageDialog(
						    null, 
						    "No existe empleado con ese tipo.", 
						    "Error", 
						    JOptionPane.WARNING_MESSAGE
						);	
				}else {
					vista.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidenciasTipo);
				}	
			}
			
		}else if(comando.equals("INICIO")) {
			vista.getVentanaPrincipal().getPanelBusqueda().setVisible(false);
			vista.getVentanaPrincipal().getPanelInferior().setVisible(false);
			vista.getVentanaPrincipal().getPanelTabla().setVisible(false);
			
		}else if(comando.equals("GESTIONAR")) {
			vista.getVentanaPrincipal().getPanelBusqueda().setVisible(true);
			vista.getVentanaPrincipal().getPanelInferior().setVisible(true);
			vista.getVentanaPrincipal().getPanelTabla().setVisible(true);
			
		}else if(comando.equals("CREAR_EMPLEADO")) {
			vista.getVentanaEmpleado().setVisible(true);
		}else if(comando.equals("EDITAR_EMPLEADO")) {
			vista.getVentanaEmpleado().setVisible(true);
		}	
	}
}
