package co.edu.unbosque.model;

import java.time.LocalDate;

public class Tecnico extends EmpleadoSalarioFijo implements SalarioBonificable{

	public Tecnico(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public double calcularBonificacion() {
		int edad = calcularEdad();
		if(edad > 40) {
			return 0.05;
		}else {
			return 0.02;
		}
	}

	@Override
	public double calcularSalarioTotal() {
		return calcularSalario() + calcularBonificacion();
	}
	
	@Override
	public String getTipoEmpleado() {
		return "Técnico";
	}

}
