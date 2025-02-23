package co.edu.unbosque.model;

import java.time.LocalDate;

public class EmpleadoSalarioFijo extends Empleado implements SalarioCalculable{
	protected final double SALARIO_FIJO = 3000000.0;

	public EmpleadoSalarioFijo(String cedula, String nombre, String apellidos, String telefono,
			String correoInstitucional, String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);	
	}
	
	
	public double getSALARIO_FIJO() {
		return SALARIO_FIJO;
	}

	@Override
	public double calcularSalario() {
		double porcentaje = calcularPorcentajeAntiguedad();
		return SALARIO_FIJO + (SALARIO_FIJO * porcentaje);
	}
	
	public double calcularPorcentajeAntiguedad() {
		int antiguedad = calcularAntiguedad();
		if(antiguedad < 2) {
			return 0;
		}else if(antiguedad >= 2 && antiguedad <=3) {
			return 0.03;
		}else if(antiguedad >=4 && antiguedad <= 7) {
			return 0.06;
		}else if(antiguedad >=8 && antiguedad <=15) {
			return 0.09;
		}else { 
			return 0.15;
		}
	}
	

}
