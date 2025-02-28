package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Empleado> listaEmpleados;
	
	
	public Empresa() {
		this.listaEmpleados = new ArrayList<>();
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		listaEmpleados.add(empleado);
	}
	
	public boolean eliminarEmpleado(String cedulaEliminar) {
		Empleado empleadoEliminar = buscarEmpleadoPorCedula(cedulaEliminar);
		if(empleadoEliminar == null) {
			return false;
		}
		listaEmpleados.remove(empleadoEliminar);
		return true;
	}
	
	public Empleado buscarEmpleadoPorCedula(String cedulaBuscar) {
		for(Empleado empleado : listaEmpleados) {
			if(empleado.getCedula().equals(cedulaBuscar)) {
				return empleado;
			}
		}
		return null;
	}
	
	public Empleado buscarEmpleadoPorCorreo(String correoBuscar) {
	    for (Empleado empleado : listaEmpleados) {
	        if (empleado.getCorreoInstitucional().equalsIgnoreCase(correoBuscar)) {
	            return empleado;
	        }
	    }
	    return null;
	}
	

	public List<Empleado> buscarEmpleadoPorNombre(String nombreOApellidoBuscar) {
	    List<Empleado> empleadosCoincidentes = new ArrayList<>();
	    for (Empleado empleado : listaEmpleados) {
	        String nombreCompleto = empleado.getNombre() + " " + empleado.getApellidos();
	        if (empleado.getNombre().equalsIgnoreCase(nombreOApellidoBuscar) ||
	            empleado.getApellidos().equalsIgnoreCase(nombreOApellidoBuscar) ||
	            nombreCompleto.toLowerCase().contains(nombreOApellidoBuscar.toLowerCase())) {
	            empleadosCoincidentes.add(empleado);
	        }
	    }
	    return empleadosCoincidentes;
	}




}
