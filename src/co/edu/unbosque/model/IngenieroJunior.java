package co.edu.unbosque.model;

import java.time.LocalDate;

public class IngenieroJunior extends EmpleadoSalarioFijo implements SalarioBonificable{
	NivelIngenieroJunior nivel;

	public IngenieroJunior(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento, NivelIngenieroJunior nivel) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.nivel = nivel;	
	}
	
	public NivelIngenieroJunior getNivel() {
		return nivel;
	}

	public void setNivel(NivelIngenieroJunior nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {
		return "El cargo es: Ingeniero Junior\n" 
				+ super.toString()
				+ "\nEl nivel del ingeniero es: " + nivel;
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

	public boolean ascenderIngenieroJunior() {
		if(nivel == NivelIngenieroJunior.NIVEL_1) {
			nivel = NivelIngenieroJunior.NIVEL_2;
			return true;
		}else if(nivel == NivelIngenieroJunior.NIVEL_2) {
			nivel = NivelIngenieroJunior.NIVEL_3;
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String getTipoEmpleado() {
		return "Ingeniero Junior";
	}

}
