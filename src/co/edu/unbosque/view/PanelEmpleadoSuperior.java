package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelEmpleadoSuperior extends JPanel {

    private JTextField cedulaField, nombreField, apellidosField, telefonoField, correoField, direccionField;
    private JComboBox<String> tipoEmpleadoComboBox, generoComboBox;
    private JTextField anioIngresoField;
    private JSpinner fechaNacimiento;

    public PanelEmpleadoSuperior() {
        setLayout(new GridLayout(10, 2, 10, 10)); 

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        add(new JLabel("Cédula:"));
        cedulaField = new JTextField(20);
        cedulaField.setEditable(false);
        add(cedulaField);

        add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        add(nombreField);

        add(new JLabel("Apellidos:"));
        apellidosField = new JTextField(20);
        add(apellidosField);

        add(new JLabel("Teléfono:"));
        telefonoField = new JTextField(20);
        add(telefonoField);

        add(new JLabel("Correo institucional:"));
        correoField = new JTextField(20);
        add(correoField);

        add(new JLabel("Dirección domiciliaria:"));
        direccionField = new JTextField(20);
        add(direccionField);

        add(new JLabel("Año de Ingreso:"));
        anioIngresoField = new JTextField(20);
        add(anioIngresoField);

        add(new JLabel("Género:"));
        generoComboBox = new JComboBox<>(new String[] {"Seleccionar", "Masculino", "Femenino"});
        add(generoComboBox);

        add(new JLabel("Fecha de nacimiento:"));
        fechaNacimiento = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaNacimiento, "yyyy-MM-dd");
        fechaNacimiento.setEditor(editor);
        add(fechaNacimiento);

        add(new JLabel("Tipo de empleado:"));
        tipoEmpleadoComboBox = new JComboBox<>(new String[]{"Seleccionar", "Ingeniero Junior", "Ingeniero Senior", "Técnico", "Empleado a Comisión"});
        tipoEmpleadoComboBox.setActionCommand("TIPO_EMPLEADO");
        add(tipoEmpleadoComboBox);
    }

	public JTextField getCedulaField() {
		return cedulaField;
	}

	public void setCedulaField(JTextField cedulaField) {
		this.cedulaField = cedulaField;
	}

	public JTextField getNombreField() {
		return nombreField;
	}

	public void setNombreField(JTextField nombreField) {
		this.nombreField = nombreField;
	}

	public JTextField getApellidosField() {
		return apellidosField;
	}

	public void setApellidosField(JTextField apellidosField) {
		this.apellidosField = apellidosField;
	}

	public JTextField getTelefonoField() {
		return telefonoField;
	}

	public void setTelefonoField(JTextField telefonoField) {
		this.telefonoField = telefonoField;
	}

	public JTextField getCorreoField() {
		return correoField;
	}

	public void setCorreoField(JTextField correoField) {
		this.correoField = correoField;
	}

	public JTextField getDireccionField() {
		return direccionField;
	}

	public void setDireccionField(JTextField direccionField) {
		this.direccionField = direccionField;
	}

	public JComboBox<String> getTipoEmpleadoComboBox() {
		return tipoEmpleadoComboBox;
	}

	public void setTipoEmpleadoComboBox(JComboBox<String> tipoEmpleadoComboBox) {
		this.tipoEmpleadoComboBox = tipoEmpleadoComboBox;
	}

	public JTextField getAnioIngresoField() {
		return anioIngresoField;
	}

	public void setAnioIngresoField(JTextField anioIngresoField) {
		this.anioIngresoField = anioIngresoField;
	}

	public JComboBox getGeneroComboBox() {
		return generoComboBox;
	}

	public void setGeneroComboBox(JComboBox generoComboBox) {
		this.generoComboBox = generoComboBox;
	}

	public JSpinner getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(JSpinner fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
