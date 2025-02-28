/**
 * Clase abstracta que representa el empleado de la empresa.
 * Proporciona atributos en común, métodos en común para todos
 * los empleados.
 * @author Kevin Toro
 * @version 1.0
 * 
 */

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
	
	/**
	 *Constructor para la clase abstracta empleado
	 *
	 *@param cedula la cedula del empleado
	 *@param nombre el nombre del empleado
	 *@param apellidos los apellidos del empleado
	 *@param telefono el telefono del empleado
	 *@param correoInstitucional debe ser unsbosque.edu.co
	 *@param direccionDomiciliaria la direccion del empleado
	 *@param anioIngreso, el anio en que in gresa el empleado
	 *@param genero, el genero del empleado (masculino o femenino)
	 *@param fechaNacimiento La fecha de nacimiento del empleado
	 */
	
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
	
	@Override
	public String toString() {
		return String.format(
				"El nombre del empleado es: %s\n"
				+ "Los apellidos del empleado son: %s\n"
				+ "La cédula del empleado es: %s\n"
				+ "El teléfono del empleado es: %s\n"
				+ "El correo del empleado es: %s\n"
				+ "La dirección del empleado es: %s\n"
				+ "El anio de ingreso del empleado fué: %d\n"
				+ "El género del empleado es: %s\n"
				+ "La edad del empleado es: %d\n"
				+ "La antigüedad del empleado es: %d\n",
				nombre, apellidos, cedula, telefono, correoInstitucional,
				direccionDomiciliaria, anioIngreso, genero, calcularEdad(),
				calcularAntiguedad());
	}
	
	/**
	 * Calcula la antigüedad del empleado en la empresa
	 * 
	 * @return El número de años de antigüedad
	 */
	public int calcularAntiguedad() {
		int anioActual = java.time.Year.now().getValue();
		return anioActual - this.anioIngreso;
	}
	
	/**
	 * Calcula la edad del empleado
	 * 
	 * @return La edad del empleado
	 */
	public int calcularEdad() {
		return LocalDate.now().getYear() - fechaNacimiento.getYear();
	}
	
	public String getTipoEmpleado() {
		return "Empleado";
	}
	
}
