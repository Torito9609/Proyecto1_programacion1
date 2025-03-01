/**
  * Clase que representa un empleado por comisión
 * implementa las interfaces que calculan salario y 
 * bonifican salario proporcionando la lógica pertinente.
 * @author Kevin Toro
 * @version 1.0
 */

package co.edu.unbosque.model;

import java.time.LocalDate;

public class EmpleadoComision extends Empleado implements SalarioCalculable, SalarioBonificable{
	private double salario = 1200000.00;
	private int clientesCaptados;
	private double comisionPorCliente;
	
	/**
	 * 
	 * @param cedula
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param correoInstitucional
	 * @param direccionDomiciliaria
	 * @param anioIngreso
	 * @param genero
	 * @param fechaNacimiento
	 * @param clientesCaptados 
	 */
	public EmpleadoComision(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.clientesCaptados = 0;
		this.comisionPorCliente = 0;
	}
	
	public EmpleadoComision(String cedula, String nombre, String apellidos, String telefono, String correoInstitucional,
			String direccionDomiciliaria, int anioIngreso, String genero, LocalDate fechaNacimiento, int clientes) {
		super(cedula, nombre, apellidos, telefono, correoInstitucional, direccionDomiciliaria, anioIngreso, genero, fechaNacimiento);
		this.clientesCaptados = clientes;
		asignarComisionPorCliente();
		calcularSalario();  
	}
	

	public int getClientesCaptados() {
		return clientesCaptados;
	}


	public void setClientesCaptados(int clientesCaptados) {
		this.clientesCaptados = clientesCaptados;
		calcularSalario();  
	}


	public double getComisionPorCliente() {
		return comisionPorCliente;
	}


	public void setComisionPorCliente(double comisionPorCliente) {
		this.comisionPorCliente = comisionPorCliente;
		calcularSalario();  
	}


	public double getSALARIO_FIJO() {
		return salario;
	}
	
	@Override
	public String toString() {
		return "El tipo de empleado es: Por comisión\n"
				+ super.toString() 
				+ String.format(
				"\nEl salario fijo del empleado es: %f\n"
				+ "Los clientes captados son: %d\n"
				+ "La comisión por cliente es: %f\n",
				salario, clientesCaptados, comisionPorCliente);
	}

	@Override
	public double calcularSalario() {
		double salarioBonificado = calcularBonificacion();
		if (salarioBonificado < salario) {
			salario += salarioBonificado;  
		} else {
			salario = salarioBonificado;  
		}
		return salario;
	}

	@Override
	public double calcularBonificacion() {
		return comisionPorCliente * clientesCaptados;
	}
	
	public void asignarComisionPorCliente() {
		int min = 500000;
		int max = 2000000;
		comisionPorCliente = (int) (Math.random() * (max - min + 1)) + min;
		calcularSalario();  
	}
	
	public boolean asignarNumeroClientes(int numeroClientes) {
	    if (numeroClientes > 0) {
	        clientesCaptados = numeroClientes;
	        asignarComisionPorCliente();
	        calcularSalario(); 
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override
	public String getTipoEmpleado() {
		return "Empleado a Comisión";
	}

	@Override
	public void actualizarAtributoEspecifico(Object clientesCaptados) {
		this.clientesCaptados = (int) clientesCaptados;
		asignarComisionPorCliente();
		calcularSalario();  
	}

	@Override
	public double calcularSalarioTotal() {
		return calcularSalario();
	}
}
