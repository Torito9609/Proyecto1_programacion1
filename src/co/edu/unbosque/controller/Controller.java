package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.Empresa;
import co.edu.unbosque.view.PanelEmpleadoComision;
import co.edu.unbosque.view.PanelIngenieroJunior;
import co.edu.unbosque.view.PanelIngenieroSenior;
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
		vista.getVentanaEmpleado().getPanelDinamico().getEditarButton().addActionListener(this);
		vista.getVentanaEmpleado().getPanelDinamico().getCancelarButton().addActionListener(this);
		vista.getVentanaEmpleado().getPanelDinamico().getCrearButton().addActionListener(this);
		vista.getVentanaPrincipal().getPanelInferior().getEliminarButton().addActionListener(this);
		
	}
	
	public String obtenerTextoBusqueda() {
		return vista.getVentanaPrincipal().getPanelBusqueda().getBuscarTextField().getText().trim().toLowerCase();
	}
	
	public void reiniciarCamposEdicionCreacion() {
		vista.getVentanaEmpleado().getPanelSuperior().getCedulaField().setText("");
		vista.getVentanaEmpleado().getPanelSuperior().getNombreField().setText("");
		vista.getVentanaEmpleado().getPanelSuperior().getApellidosField().setText("");
		vista.getVentanaEmpleado().getPanelSuperior().getTelefonoField().setText("");
		vista.getVentanaEmpleado().getPanelSuperior().getCorreoField().setText("");
		vista.getVentanaEmpleado().getPanelSuperior().getDireccionField().setText("");
		vista.getVentanaEmpleado().getPanelSuperior().getAnioIngresoField().setText("");
		vista.getVentanaEmpleado().getPanelSuperior().getGeneroComboBox().setSelectedItem("Seleccionar");
		Date fechaGenerica = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
		vista.getVentanaEmpleado().getPanelSuperior().getFechaNacimiento().setValue(fechaGenerica);
		vista.getVentanaEmpleado().getPanelSuperior().getTipoEmpleadoComboBox().setSelectedItem("Seleccionar");
	}
	
	public boolean validarEntradasEmpleado(String cedula, String nombre, String apellidos, String telefono, String correo, LocalDate fechaNacimiento, String anioIngreso) {
	    if (cedula == null || cedula.trim().isEmpty()) {
	        vista.mostrarMensajeError("La cédula no puede estar vacía.");
	        return false;
	    }
	    
	    for (char c : cedula.toCharArray()) {
	        if (!Character.isDigit(c)) {
	            vista.mostrarMensajeError("La cédula solo puede contener números.");
	            return false;
	        }
	    }
	    
	    if (cedula.length() < 7 || cedula.length() > 10) {
	        vista.mostrarMensajeError("La cédula debe tener entre 7 y 10 dígitos.");
	        return false;
	    }

	    if (correo == null || correo.trim().isEmpty()) {
	        vista.mostrarMensajeError("El correo no puede estar vacío.");
	        return false;
	    }

	    if (!correo.contains("@")) {
	        vista.mostrarMensajeError("El correo debe contener '@'.");
	        return false;
	    }

	    if (!correo.endsWith("@unbosque.edu.co")) {
	        vista.mostrarMensajeError("El correo debe ser del dominio @unbosque.edu.co.");
	        return false;
	    }
	    
	    String parteLocal = correo.substring(0, correo.indexOf("@"));
	    if (parteLocal.isEmpty()) {
	        vista.mostrarMensajeError("El correo debe contener una parte local antes de '@'.");
	        return false;
	    }

	    if (nombre.trim().isEmpty() || apellidos.trim().isEmpty()) {
	        vista.mostrarMensajeError("El nombre y los apellidos no pueden estar vacíos.");
	        return false;
	    }
	    
	    for (char c : nombre.trim().toCharArray()) {
	        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
	            vista.mostrarMensajeError("El nombre solo puede contener letras y espacios.");
	            return false;
	        }
	    }
	    
	    for (char c : apellidos.trim().toCharArray()) {
	        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
	            vista.mostrarMensajeError("El apellido solo puede contener letras y espacios.");
	            return false;
	        }
	    }

	    if (telefono == null || telefono.trim().isEmpty()) {
	        vista.mostrarMensajeError("El teléfono no puede estar vacío.");
	        return false;
	    }

	    for (char c : telefono.toCharArray()) {
	        if (!Character.isDigit(c)) {
	            vista.mostrarMensajeError("El teléfono solo puede contener números.");
	            return false;
	        }
	    }

	    if (telefono.length() < 7 || telefono.length() > 10) {
	        vista.mostrarMensajeError("El teléfono debe tener entre 7 y 10 dígitos.");
	        return false;
	    }

	    if (fechaNacimiento.isAfter(LocalDate.now())) {
	        vista.mostrarMensajeError("La fecha de nacimiento no puede ser en el futuro.");
	        return false;
	    }
	    try {
	        int anioIngresoInt = Integer.parseInt(anioIngreso);
	        if (anioIngresoInt < 1900 || anioIngresoInt > LocalDate.now().getYear()) {
	            vista.mostrarMensajeError("El año de ingreso debe ser un valor entre 1900 y el año actual.");
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        vista.mostrarMensajeError("El año de ingreso debe ser un número entero.");
	        return false;
	    }

	    return true;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("BUSCAR")) {
			String texto = obtenerTextoBusqueda();
			int pos = vista.getVentanaPrincipal().getPanelBusqueda().getBuscarPorComboBox().getSelectedIndex();
			String tipoBusqueda = vista.getVentanaPrincipal().getPanelBusqueda().getBuscarPorComboBox().getItemAt(pos).toLowerCase();
			List<Empleado> coincidencias = new ArrayList();
			
			if(tipoBusqueda == null || tipoBusqueda.isEmpty() || tipoBusqueda.equals("Seleccionar")) {
				vista.mostrarMensajeError("Por favor seleccione un tipo de búsqueda.");
				
			}else if(texto == null || texto.isEmpty()){
				vista.mostrarMensajeError("Por favor ingrese algo para buscar.");
				
			}else if(tipoBusqueda.equals("nombre")){
				String nombreBuscar = texto;
				coincidencias = empresa.buscarEmpleadoPorNombre(nombreBuscar);
				
				if(coincidencias.isEmpty()) {
					vista.mostrarMensajeAdvertencia("No se encontró el empleado.");		
				}else {
					vista.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
				}
				
			
			}else if(tipoBusqueda.equals("cédula")) {
				String cedulaBuscar = texto;
				Empleado empleadoEncontrado = empresa.buscarEmpleadoPorCedula(cedulaBuscar);
				
				if(empleadoEncontrado == null) {
					vista.mostrarMensajeAdvertencia("No se encontró el empleado.");
				}else {
					coincidencias.add(empleadoEncontrado);
					vista.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
				}
				
			}else if(tipoBusqueda.equals("correo")) {
				String correoBuscar = texto;
				Empleado empleadoEncontrado = empresa.buscarEmpleadoPorCorreo(correoBuscar);
				
				if(empleadoEncontrado == null) {
					vista.mostrarMensajeAdvertencia("No se encontró el empleado.");
				}else {
					coincidencias.add(empleadoEncontrado);
					vista.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
				}	
			}
			
		}else if(comando.equals("TIPO")) {
			int pos2 = vista.getVentanaPrincipal().getPanelBusqueda().getTipoEmpleadoComboBox().getSelectedIndex();
			String opcion = vista.getVentanaPrincipal().getPanelBusqueda().getTipoEmpleadoComboBox().getItemAt(pos2).toLowerCase();
			
			
			if(opcion.equals("seleccionar")) {
				reiniciarTabla();
				
			}else {
				List<Empleado> coincidenciasTipo = new ArrayList();
				coincidenciasTipo = empresa.filtrarEmpleadoPorTipo(opcion);
				
				if(coincidenciasTipo.isEmpty()) {
					vista.mostrarMensajeAdvertencia("No se encontró el empleado.");
				}else {
					vista.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidenciasTipo);
				}	
			}
		
		}else if(comando.equals("ELIMINAR_EMPLEADO")) {
			int filaSeleccionada = vista.getVentanaPrincipal().getPanelTabla().getTablaEmpleados().getSelectedRow();
			if(filaSeleccionada== -1) {
				vista.mostrarMensajeError("Por favor, seleccione un empleado de la tabla.");
				
			}else {
				int opcion = vista.mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el empleado?");
				
				if(opcion == JOptionPane.YES_OPTION) {
					String cedulaEliminar = vista.getVentanaPrincipal().getPanelTabla().getTablaEmpleados().getValueAt(filaSeleccionada, 0).toString();
					empresa.eliminarEmpleado(cedulaEliminar);
					vista.mostrarMensajeExito("Empleado eliminado exitosamente");
					reiniciarTabla();
				}else {
					vista.mostrarMensajeExito("Operación cancelada exitosamente.");
				}
				
			}
			
			
		}else if(comando.equals("CREAR_EMPLEADO")) {
			reiniciarCamposEdicionCreacion();
			vista.getVentanaEmpleado().setVisible(true);
			
		}else if(comando.equals("EDITAR_EMPLEADO")) {
			int filaSeleccionada = vista.getVentanaPrincipal().getPanelTabla().getTablaEmpleados().getSelectedRow();
			
			if(filaSeleccionada== -1) {
				vista.mostrarMensajeError("Por favor, seleccione un empleado de la tabla.");
				
			}else {
				String cedulaEditar = vista.getVentanaPrincipal().getPanelTabla().getTablaEmpleados().getValueAt(filaSeleccionada, 0).toString();
				Empleado empleadoEditar = empresa.buscarEmpleadoPorCedula(cedulaEditar);
				
				if(empleadoEditar == null) {
					vista.mostrarMensajeAdvertencia("No se encontró el empleado.");
					
				}else {
					String tipoEmpleado = empleadoEditar.getTipoEmpleado();
					reiniciarCamposEdicionCreacion();
					vista.getVentanaEmpleado().getPanelSuperior().getCedulaField().setText(empleadoEditar.getCedula());
					vista.getVentanaEmpleado().getPanelSuperior().getNombreField().setText(empleadoEditar.getNombre());
					vista.getVentanaEmpleado().getPanelSuperior().getApellidosField().setText(empleadoEditar.getApellidos());
					vista.getVentanaEmpleado().getPanelSuperior().getTelefonoField().setText(empleadoEditar.getTelefono());
					vista.getVentanaEmpleado().getPanelSuperior().getCorreoField().setText(empleadoEditar.getCorreoInstitucional());
					vista.getVentanaEmpleado().getPanelSuperior().getDireccionField().setText(empleadoEditar.getDireccionDomiciliaria());
					vista.getVentanaEmpleado().getPanelSuperior().getAnioIngresoField().setText((Integer.toString(empleadoEditar.getAnioIngreso())));
					vista.getVentanaEmpleado().getPanelSuperior().getGeneroComboBox().setSelectedItem(empleadoEditar.getGenero());
					LocalDate fechaNacimiento = empleadoEditar.getFechaNacimiento();
					Date date = Date.from(fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());
					vista.getVentanaEmpleado().getPanelSuperior().getFechaNacimiento().setValue(date);
					vista.getVentanaEmpleado().getPanelSuperior().getTipoEmpleadoComboBox().setSelectedItem(empleadoEditar.getTipoEmpleado());
					vista.getVentanaEmpleado().setVisible(true);
				}	
			}	
		}else if(comando.equals("TIPO_EMPLEADO")) {
			String tipoEmpleado = vista.getVentanaEmpleado().getPanelSuperior().getTipoEmpleadoComboBox().getSelectedItem().toString();
			vista.getVentanaEmpleado().getPanelDinamico().mostrarPanel(tipoEmpleado);
		}
		else if(comando.equals("EDITAR")) {
			
			String cedulaOriginal = vista.getVentanaEmpleado().getPanelSuperior().getCedulaField().getText().trim();
			
			String cedulaNueva = vista.getVentanaEmpleado().getPanelSuperior().getCedulaField().getText();
            String nombre = vista.getVentanaEmpleado().getPanelSuperior().getNombreField().getText();
            String apellidos = vista.getVentanaEmpleado().getPanelSuperior().getApellidosField().getText();
            String telefono = vista.getVentanaEmpleado().getPanelSuperior().getTelefonoField().getText();
            String correo = vista.getVentanaEmpleado().getPanelSuperior().getCorreoField().getText();
            String direccion = vista.getVentanaEmpleado().getPanelSuperior().getDireccionField().getText();
            String anioIngresoString = vista.getVentanaEmpleado().getPanelSuperior().getAnioIngresoField().getText();
            String genero = vista.getVentanaEmpleado().getPanelSuperior().getGeneroComboBox().getSelectedItem().toString();
            LocalDate fechaNacimiento = ((Date) vista.getVentanaEmpleado().getPanelSuperior().getFechaNacimiento().getValue())
                                        .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            boolean validado = validarEntradasEmpleado(cedulaNueva, nombre, apellidos, telefono, correo, fechaNacimiento, anioIngresoString);
            
            if(!validado) {
            	vista.mostrarMensajeError("Verifique que los campos ingresados son válidos.");
            	
            }else {
                int anioIngreso = Integer.parseInt(anioIngresoString);
                String tipoEmpleadoNuevo = vista.getVentanaEmpleado().getPanelSuperior().getTipoEmpleadoComboBox().getSelectedItem().toString();
                Empleado empleadoActual = empresa.buscarEmpleadoPorCedula(cedulaOriginal);

                if(!empleadoActual.getTipoEmpleado().equals(tipoEmpleadoNuevo)) {
                	empresa.eliminarEmpleado(cedulaOriginal);
                	
                	if(tipoEmpleadoNuevo.equals("Ingeniero Junior")) {
                    	PanelIngenieroJunior panelJunior = (PanelIngenieroJunior) vista.getVentanaEmpleado().getPanelDinamico().getPanelActual();
                    	String nivel = panelJunior.getNivelComboBox().getSelectedItem().toString();
                    	
                    	int confirmacion = vista.mostrarMensajeConfirmacion("¿Está seguro de editar el empleado?");
                    	
                    	if(confirmacion == JOptionPane.YES_OPTION) {
                    		Empleado empleadoActualizado = empresa.crearEmpleado(tipoEmpleadoNuevo, cedulaNueva, nombre, apellidos, telefono, correo, direccion, anioIngreso, fechaNacimiento, genero, nivel);
                        	empresa.agregarEmpleado(empleadoActualizado);
                        	reiniciarTabla();
                        	vista.mostrarMensajeExito("Empleado editado con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}else {
                    		vista.mostrarMensajeExito("Operación cancelada con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}
                    	
                    	
                    }else if(tipoEmpleadoNuevo.equals("Ingeniero Senior")) {
                    	PanelIngenieroSenior panelSenior = (PanelIngenieroSenior) vista.getVentanaEmpleado().getPanelDinamico().getPanelActual();
                    	int numeroVentas = Integer.parseInt(panelSenior.getNumeroVentasField().getText());
                    	
                    	int confirmacion = vista.mostrarMensajeConfirmacion("¿Está seguro de editar el empleado?");
                    	
                    	if(confirmacion == JOptionPane.YES_OPTION) {
                    		Empleado empleadoActualizado = empresa.crearEmpleado(tipoEmpleadoNuevo, cedulaNueva, nombre, apellidos, telefono, correo, direccion, anioIngreso, fechaNacimiento, genero, numeroVentas);
                        	empresa.agregarEmpleado(empleadoActualizado);
                        	reiniciarTabla();
                        	vista.mostrarMensajeExito("Empleado editado con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}else {
                    		vista.mostrarMensajeExito("Operación cancelada con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}
                    		
                    	
                    }else if(tipoEmpleadoNuevo.equals("Empleado a Comisión")) {
                    	PanelEmpleadoComision  panelComision = (PanelEmpleadoComision) vista.getVentanaEmpleado().getPanelDinamico().getPanelActual();
                    	int clientesCaptados = Integer.parseInt(panelComision.getClientesCaptadosField().getText());
                    	
                    	int confirmacion = vista.mostrarMensajeConfirmacion("¿Está seguro de editar el empleado?");
                
                    	if(confirmacion == JOptionPane.YES_OPTION) {
                    		Empleado empleadoActualizado = empresa.crearEmpleado(tipoEmpleadoNuevo, cedulaNueva, nombre, apellidos, telefono, correo, direccion, anioIngreso, fechaNacimiento, genero, clientesCaptados);
                        	empresa.agregarEmpleado(empleadoActualizado);
                        	reiniciarTabla();
                        	vista.mostrarMensajeExito("Empleado editado con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}else {
                    		vista.mostrarMensajeExito("Operación cancelada con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}
                    		
                    }else if(tipoEmpleadoNuevo.equals("Técnico")) {
                    	
                    	int confirmacion = vista.mostrarMensajeConfirmacion("¿Está seguro de editar el empleado?");
                    	
                    	if(confirmacion == JOptionPane.YES_OPTION) {
                    		Empleado empleadoActualizado = empresa.crearEmpleado(tipoEmpleadoNuevo, cedulaNueva, nombre, apellidos, telefono, correo, direccion, anioIngreso, fechaNacimiento, genero, null);
                        	empresa.agregarEmpleado(empleadoActualizado);
                        	reiniciarTabla();
                        	vista.mostrarMensajeExito("Empleado editado con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}else {
                    		vista.mostrarMensajeExito("Operación cancelada con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}  	
                    	
                    }
                	
                }else {
                	empleadoActual.setNombre(nombre);
                    empleadoActual.setApellidos(apellidos);
                    empleadoActual.setTelefono(telefono);
                    empleadoActual.setCorreoInstitucional(correo);
                    empleadoActual.setDireccionDomiciliaria(direccion);
                    empleadoActual.setAnioIngreso(anioIngreso);
                    empleadoActual.setGenero(genero);
                    empleadoActual.setFechaNacimiento(fechaNacimiento);
                    
                    String nombreOriginal = empleadoActual.getNombre();
                    String apellidosOriginal = empleadoActual.getApellidos();
                    String telefonoOriginal = empleadoActual.getTelefono();
                    String correoOriginal = empleadoActual.getCorreoInstitucional();
                    String direccionOriginal = empleadoActual.getDireccionDomiciliaria();
                    int anioIngresoOriginal = empleadoActual.getAnioIngreso();
                    String generoOriginal = empleadoActual.getGenero();
                    LocalDate fechaNacimientoOriginal = empleadoActual.getFechaNacimiento();
                    
                    String tipoActual = empleadoActual.getTipoEmpleado();
                    
                    if(tipoActual.equals("Ingeniero Junior")) {
                        PanelIngenieroJunior panelJunior = (PanelIngenieroJunior) vista.getVentanaEmpleado().getPanelDinamico().getPanelActual();
                        String nivel = panelJunior.getNivelComboBox().getSelectedItem().toString();
                        
                        int confirmacion = vista.mostrarMensajeConfirmacion("¿Está seguro de editar el empleado?");

                        if(confirmacion == JOptionPane.YES_OPTION) {
                            empleadoActual.actualizarAtributoEspecifico(nivel);
                            reiniciarTabla();
                            vista.mostrarMensajeExito("Empleado editado con éxito");  
                            vista.getVentanaEmpleado().setVisible(false); 
                        } else {
                        	vista.mostrarMensajeExito("Operación cancelada con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                        }
                        
                    }else if(tipoActual.equals("Ingeniero Senior")) {
                    	PanelIngenieroSenior panelSenior = (PanelIngenieroSenior) vista.getVentanaEmpleado().getPanelDinamico().getPanelActual();
                    	int numeroVentas = Integer.parseInt(panelSenior.getNumeroVentasField().getText());
                    	
                    	int confirmacion = vista.mostrarMensajeConfirmacion("¿Está seguro de editar el empleado?");
                    	
                    	if(confirmacion == JOptionPane.YES_OPTION) {
                    		empleadoActual.actualizarAtributoEspecifico(numeroVentas);
                        	reiniciarTabla();
                        	vista.mostrarMensajeExito("Empleado editado con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}else {
                    		vista.mostrarMensajeExito("Operación cancelada con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                        }
                    	
                    	
                    }else if(tipoActual.equals("Empleado a Comisión")) {
                    	PanelEmpleadoComision  panelComision = (PanelEmpleadoComision) vista.getVentanaEmpleado().getPanelDinamico().getPanelActual();
                    	int clientesCaptados = Integer.parseInt(panelComision.getClientesCaptadosField().getText());
                    	
                    	int confirmacion = vista.mostrarMensajeConfirmacion("¿Está seguro de editar el empleado?");
                    	
                    	if(confirmacion == JOptionPane.YES_OPTION) {
                    		empleadoActual.actualizarAtributoEspecifico(clientesCaptados);
                        	vista.mostrarMensajeExito("Empleado editado con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                        	reiniciarTabla();
                    	}else {
                    		vista.mostrarMensajeExito("Operación cancelada con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                        }	
                    }else if(tipoActual.equals("Técnico")) {
                    	int confirmacion = vista.mostrarMensajeConfirmacion("¿Está seguro de editar el empleado?");
                    	
                    	if(confirmacion == JOptionPane.YES_OPTION) {
                    		vista.mostrarMensajeExito("Empleado actualizado con éxito");
                    		reiniciarTabla();
                    	}else {
                    		empleadoActual.setNombre(nombreOriginal);
                    		empleadoActual.setApellidos(apellidosOriginal);
                    		empleadoActual.setTelefono(telefonoOriginal);
                    		empleadoActual.setCorreoInstitucional(correoOriginal);
                    		empleadoActual.setDireccionDomiciliaria(direccionOriginal);
                    		empleadoActual.setAnioIngreso(anioIngresoOriginal);
                    		empleadoActual.setGenero(generoOriginal);
                    		empleadoActual.setFechaNacimiento(fechaNacimientoOriginal);
                    		vista.mostrarMensajeExito("Operación cancelada con éxito");
                        	vista.getVentanaEmpleado().setVisible(false);
                    	}
                    }
                }
                
            }
            
		}else if(comando.equals("CREAR")) {
			
		}else if(comando.equals("CANCELAR")) {
			
		}
	}
}