package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Empleado> listaEmpleados;
	
	public Empresa() {
		this.listaEmpleados = new ArrayList<>();
		Empleado prueba1 = new IngenieroJunior(
				"1022419274",
				"Ing Junior",
				"Prueba",
				"1235698",
				"junior@unbosque.edu.co",
				"calle falsa 123",
				2024,
				"Masculino",
				LocalDate.of(1996,9,9),
				NivelIngenieroJunior.NIVEL_1);
		
		Empleado prueba2 = new IngenieroSenior(
				"1022419275",
				"Ing Senior",
				"Prueba",
				"654987",
				"senior@unbosque.edu.co",
				"calle falsa 123",
				2024,
				"Masculino",
				LocalDate.of(1996,9,9));
		
		Empleado prueba3 = new Tecnico(
				"1022419276", 
				"Tecnico", 
				"Prueba", 
				"654654654", 
				"tecnico@unbosque.edu.co", 
				"Calle falsa 123", 
				2002,
				"Femenino", 
				LocalDate.of(1987,10,28));
		
		Empleado prueba4 = new EmpleadoComision(
				"1022419277", 
				"Comision", 
				"Prueba", 
				"654654", 
				"comision@unbosque.edu.co", 
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
	
	public Empleado crearEmpleado(String tipo, String cedula, String nombre, String apellidos, String telefono, 
            String correo, String direccion, int anioIngreso, LocalDate fechaNacimiento, String genero, Object atributoAdicional) {
    
    for (Empleado empleadoExistente : listaEmpleados) {
        if (empleadoExistente.getCedula().equals(cedula)) {
            System.out.println("Error: Ya existe un empleado con la misma cédula.");
            return null; 
        }
        if (empleadoExistente.getCorreoInstitucional().equals(correo)) {
            return null;
        }
    }

    switch(tipo) {
        case "Ingeniero Junior":
            String nivelString = (String)atributoAdicional;
            NivelIngenieroJunior nivelJunior;
            if(nivelString.equals("Nivel 1")) {
                nivelJunior = NivelIngenieroJunior.NIVEL_1;
            } else if(nivelString.equals("Nivel 2")) {
                nivelJunior = NivelIngenieroJunior.NIVEL_2;
            } else if(nivelString.equals("Nivel 3")) {
                nivelJunior = NivelIngenieroJunior.NIVEL_3;
            } else {
                nivelJunior = null;
            }
            return new IngenieroJunior(cedula, nombre, apellidos, telefono, correo, direccion, anioIngreso, genero, 
                    fechaNacimiento, nivelJunior);
            
        case "Ingeniero Senior":
            int numeroVentas = (int) atributoAdicional;
            return new IngenieroSenior(cedula, nombre, apellidos, telefono, correo, direccion, anioIngreso, genero, 
                    fechaNacimiento, numeroVentas);
            
        case "Tecnico":
            return new Tecnico(cedula, nombre, apellidos, telefono, correo, direccion, anioIngreso, genero, 
                    fechaNacimiento);
            
        case "Empleado a Comisión":
            int clientesCaptados = (int)atributoAdicional;
            return new EmpleadoComision(cedula, nombre, apellidos, telefono, correo, direccion, anioIngreso, genero, 
                    fechaNacimiento, clientesCaptados);
            
        default:
            return null;
    }
}




}
