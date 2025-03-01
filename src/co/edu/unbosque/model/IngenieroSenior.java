package co.edu.unbosque.model;

import java.time.LocalDate;

public class IngenieroSenior extends EmpleadoSalarioFijo implements SalarioBonificable{
	int numeroVentas;

	public IngenieroSenior(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.numeroVentas = 0;
	}
	
	public IngenieroSenior(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento, int numeroVentas) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.numeroVentas = numeroVentas;
	}
	

	public int getNumeroVentas() {
		return numeroVentas;
	}


	public void setNumeroVentas(int numeroVentas) {
		this.numeroVentas = numeroVentas;
	}
	
	
	
	@Override
	public String toString() {
		return "El cargo es: Ingeniero Senior\n"
				+ super.toString()
				+ "\nEl número de ventas cerradas es: " + numeroVentas
				+"\n El salario total es:" + calcularSalarioTotal();
	}


	public boolean asignarNumeroVentas(int numeroVentas) {
		if(numeroVentas > 0) {
			this.numeroVentas = numeroVentas;
			return true;
		}else {
			return false;
		}
	}


	@Override
	public double calcularBonificacion() {
	    double porcentaje = 0;
	    if (numeroVentas <= 4) {
	        porcentaje = 0.10;
	    } else if (numeroVentas <= 8) {
	        porcentaje = 0.15;
	    } else if (numeroVentas <= 12) {
	        porcentaje = 0.20;
	    } else {
	        porcentaje = 0.25;
	    }
	    return super.calcularSalario() * porcentaje;
	}


	@Override
	public double calcularSalarioTotal() {
		return super.calcularSalario() + calcularBonificacion();
	}
	
	@Override
	public String getTipoEmpleado() {
		return "Ingeniero Senior";
	}
	
	@Override
	public void actualizarAtributoEspecifico(Object numeroVentas) {
		asignarNumeroVentas((int)numeroVentas);
		calcularSalarioTotal();
	}

}
