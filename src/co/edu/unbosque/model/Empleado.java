package co.edu.unbosque.model;

import java.time.LocalDate;

public abstract class Empleado {
	private String cedula;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String correoInstitucional;
	private String direccionDomiciliaria;
	protected int anioIngreso;
	protected String genero;
	protected LocalDate fechaNacimiento;
	
	public Empleado(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correoInstitucional = correoInstitucional;
		this.direccionDomiciliaria = direccionDomiciliaria;
		this.anioIngreso = anioIngreso;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoInstitucional() {
		return correoInstitucional;
	}

	public void setCorreoInstitucional(String correoInstitucional) {
		this.correoInstitucional = correoInstitucional;
	}

	public String getDireccionDomiciliaria() {
		return direccionDomiciliaria;
	}

	public void setDireccionDomiciliaria(String direccionDomiciliaria) {
		this.direccionDomiciliaria = direccionDomiciliaria;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int calcularAntiguedad() {
		int anioActual = java.time.Year.now().getValue();
		return anioActual - this.anioIngreso;
	}
	
	public int calcularEdad() {
		return LocalDate.now().getYear() - fechaNacimiento.getYear();
	}
	
}
