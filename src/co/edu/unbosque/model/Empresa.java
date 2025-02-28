package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Empleado> listaEmpleados;
	
	public Empresa() {
		this.listaEmpleados = new ArrayList<>();
		Empleado prueba1 = new IngenieroJunior(
				"198987987987",
				"Ing Junior",
				"Prueba",
				"654987",
				"junior@ejemplo",
				"calle falsa 123",
				2024,
				"Masculino",
				LocalDate.of(1996,9,9),
				NivelIngenieroJunior.NIVEL_1);
		
		Empleado prueba2 = new IngenieroSenior(
				"123456",
				"Ing Senior",
				"Prueba",
				"654987",
				"senior@ejemplo",
				"calle falsa 123",
				2024,
				"Masculino",
				LocalDate.of(1996,9,9));
		
		Empleado prueba3 = new Tecnico(
				"6546546", 
				"Tecnico", 
				"Prueba", 
				"654654654", 
				"tecnico@prueba.com", 
				"Calle falsa 123", 
				2002,
				"Femenino", 
				LocalDate.of(1987,10,28));
		
		Empleado prueba4 = new EmpleadoComision(
				"321321", 
				"Comision", 
				"Prueba", 
				"654654", 
				"comision@correo.com", 
				"calle falsa 124", 
				2015, 
				"Femenino", 
				LocalDate.of(2005,9,8));
		
		listaEmpleados.add(prueba1);
		listaEmpleados.add(prueba2);
		listaEmpleados.add(prueba3);
		listaEmpleados.add(prueba4);
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
	
	public boolean editarEmpleado(String cedulaActualizar, Empleado empleadoActualizado) {
		Empleado empleadoExistente = buscarEmpleadoPorCedula(cedulaActualizar);
		if(empleadoExistente == null) {
			return false;
		}
		int index = listaEmpleados.indexOf(empleadoExistente);
		listaEmpleados.set(index, empleadoActualizado);
		return true;
	}
	
	public List<Empleado> filtrarEmpleadoPorTipo(String tipo){
	    List<Empleado> empleadosFiltrados = new ArrayList<>();

	    String tipoFiltrado = tipo.toLowerCase();

	    for (Empleado empleado : listaEmpleados) {
	        if (empleado.getTipoEmpleado().toLowerCase().equals(tipoFiltrado)) {
	            empleadosFiltrados.add(empleado);
	        }
	    }

	    return empleadosFiltrados;
	}




}
