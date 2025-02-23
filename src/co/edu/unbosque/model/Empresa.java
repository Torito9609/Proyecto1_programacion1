package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String nombre;
	private List<Empleado> listaEmpleados;
	private LocalDate fechaCreacion;
	private String direccion;
	private String telefono;
	
	public Empresa(String nombre, LocalDate fechaCreacion, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.listaEmpleados = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		listaEmpleados.add(empleado);
	}
	
	public boolean eliminarEmpleado(String cedulaEliminar) {
		Empleado empleadoEliminar = buscarEmpleado(cedulaEliminar);
		if(empleadoEliminar == null) {
			return false;
		}
		listaEmpleados.remove(empleadoEliminar);
		return true;
	}
	
	public Empleado buscarEmpleado(String cedulaBuscar) {
		for(Empleado empleado : listaEmpleados) {
			if(empleado.getCedula().equals(cedulaBuscar)) {
				return empleado;
			}
		}
		return null;
	}
	/*
	public boolean editarEmpleado(String cedulaEditar, Empleado empleadoActualizado) {
		Empleado empleadoEditar = buscarEmpleado(cedulaEditar);
		if(empleadoEditar == null) {
			return false;
		}
		
	}*/
}
