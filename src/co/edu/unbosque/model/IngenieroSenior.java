package co.edu.unbosque.model;

import java.time.LocalDate;

public class IngenieroSenior extends EmpleadoSalarioFijo implements SalarioBonificable{
	int numeroVentas;

	public IngenieroSenior(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.numeroVentas = 0;
	}
	

	public int getNumeroVentas() {
		return numeroVentas;
	}


	public void setNumeroVentas(int numeroVentas) {
		this.numeroVentas = numeroVentas;
	}
	
	public void asignarNumeroVentas(int numeroVentas) {
		if(numeroVentas > 0) {
			this.numeroVentas = numeroVentas;
		}else {
			System.out.println("EL número de ventas ni puede ser negativo");
		}
	}


	@Override
	public double calcularBonificacion() {
		if(numeroVentas <= 4) {
			return 0.1;
		}else if(numeroVentas >= 5 && numeroVentas <= 8) {
			return 0.15;
		}else if(numeroVentas >=9 && numeroVentas <= 12) {
			return 0.20;
		}else  {
			return 0.25;
		}
	}

	@Override
	public double calcularSalarioTotal() {
		return calcularSalario() + calcularBonificacion();
	}

}
