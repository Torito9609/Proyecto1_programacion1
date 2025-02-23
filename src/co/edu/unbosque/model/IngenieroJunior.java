package co.edu.unbosque.model;

import java.time.LocalDate;

public class IngenieroJunior extends EmpleadoSalarioFijo implements SalarioBonificable{
	NivelIngenieroJunior nivel;

	public IngenieroJunior(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, NivelIngenieroJunior nivel, LocalDate fechaNacimiento) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.nivel = nivel;	
	}

	@Override
	public double calcularBonificacion() {
		switch(nivel) {
		case NIVEL_2:
			return super.calcularSalario() * 0.06;
			
		case NIVEL_3:
			return super.calcularSalario() * 0.09;
			
		default:
			return 0;
		}	
	}
	
	public double calcularSalarioTotal() {
		return calcularSalario() + calcularBonificacion();
	}

}
