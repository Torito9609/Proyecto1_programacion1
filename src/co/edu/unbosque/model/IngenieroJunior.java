package co.edu.unbosque.model;

import java.time.LocalDate;

public class IngenieroJunior extends EmpleadoSalarioFijo implements SalarioBonificable{
	NivelIngenieroJunior nivel;

	public IngenieroJunior(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.nivel = NivelIngenieroJunior.NIVEL_1;	
	}
	
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
	
	@Override
	public void actualizarAtributoEspecifico(Object nivelString) {
		if(nivelString.equals("Nivel 1")) {
			nivel = NivelIngenieroJunior.NIVEL_1;
			
		}else if(nivelString.equals("Nivel 2")) {
			nivel = NivelIngenieroJunior.NIVEL_2;
			
		}else if(nivelString.equals("Nivel 3")){
			nivel = NivelIngenieroJunior.NIVEL_3;
		}
	}
	
	@Override
	public String getTipoEmpleado() {
		return "Ingeniero Junior";
	}

}
