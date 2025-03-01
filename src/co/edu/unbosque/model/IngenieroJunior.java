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
				+ "\nEl nivel del ingeniero es: " + nivel
				+"\n El salario total es: " + calcularSalarioTotal();
	}

	@Override
	public double calcularBonificacion() {
		switch(this.nivel) {
			case NIVEL_2:
				return super.calcularSalario() * 0.06;
				
			case NIVEL_3:
				return super.calcularSalario() * 0.09;
				
			default:
				return 0;
			}	
	}
	
	public double calcularSalarioTotal() {
		return super.calcularSalario() + calcularBonificacion();
	}
	
	@Override
	public void actualizarAtributoEspecifico(Object nivelString) {
		if(nivelString.equals("Nivel 1")) {
			setNivel(NivelIngenieroJunior.NIVEL_1);
			calcularSalarioTotal();
			
		}else if(nivelString.equals("Nivel 2")) {
			setNivel(NivelIngenieroJunior.NIVEL_2);
			calcularSalarioTotal();
			
		}else if(nivelString.equals("Nivel 3")){
			setNivel(NivelIngenieroJunior.NIVEL_3);
			calcularSalarioTotal();
		}
	}
	
	@Override
	public String getTipoEmpleado() {
		return "Ingeniero Junior";
	}

}
