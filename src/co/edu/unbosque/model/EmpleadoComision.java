package co.edu.unbosque.model;

import java.time.LocalDate;

public class EmpleadoComision extends Empleado implements SalarioCalculable, SalarioBonificable{
	private final double SALARIO_FIJO = 1200000.00;
	private int clientesCaptados;
	private double comisionPorCliente;
	

	public EmpleadoComision(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.clientesCaptados = 0;
		this.comisionPorCliente = 0;
	}
	

	public int getClientesCaptados() {
		return clientesCaptados;
	}


	public void setClientesCaptados(int clientesCaptados) {
		this.clientesCaptados = clientesCaptados;
	}


	public double getComisionPorCliente() {
		return comisionPorCliente;
	}


	public void setComisionPorCliente(double comisionPorCliente) {
		this.comisionPorCliente = comisionPorCliente;
	}


	public double getSALARIO_FIJO() {
		return SALARIO_FIJO;
	}
	
	@Override
	public String toString() {
		return "El tipo de empleado es: Por comisión\n"
				+ super.toString() 
				+ String.format(
				"\nEl salario fijo del empleado es: %d\n"
				+ "Los clientes captados son: %d\n"
				+ "La comisión por cleinte es: %d\n",
				SALARIO_FIJO, clientesCaptados, comisionPorCliente);
	}

	@Override
	public double calcularSalario() {
		double salarioBonificado = calcularBonificacion();
		if(salarioBonificado < SALARIO_FIJO) {
			return salarioBonificado + SALARIO_FIJO;
		}else {
			return salarioBonificado;
		}
	}

	@Override
	public double calcularBonificacion() {
		if(clientesCaptados > 10) {
			comisionPorCliente = 2000000;
		}else if(clientesCaptados > 5){
			comisionPorCliente = 1000000;
		}else {
			comisionPorCliente = 5000000;
		} 
		return comisionPorCliente * clientesCaptados;
	}

	@Override
	public double calcularSalarioTotal() {
		return calcularSalario();
	}
	
	public boolean asignarNumeroClientes(int numeroCLientes) {
		if(numeroCLientes > 0) {
			clientesCaptados = numeroCLientes;
			return true;
		} else {
			return false;
		}
	}

}
