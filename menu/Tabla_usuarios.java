package menu;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tabla_usuarios extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JLabel lblNewLabel,editar;
	JTable tablaUsuarios;
	JSeparator separator;
	JButton botonEditar;
	JComboBox<String>seleccionarUsuario;
	DefaultComboBoxModel<String>modeloSeleccion;
	
	public Tabla_usuarios() {
		this.setLayout(null);
		this.setVisible(true);
		showTabla();
	}

	private void showTabla() {
		
		lblNewLabel = new JLabel("LISTA DE USUARIOS");
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 38));
		lblNewLabel.setBounds(45, 30, 400, 44);
		this.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(10, 110, 466, 2);
		this.add(separator);
		
		editar = new JLabel("Editar:");
		editar.setFont(new Font("SansSerif", Font.BOLD, 18));
		editar.setBounds(45, 130, 70, 30);
		this.add(editar);
		
		modeloSeleccion = new DefaultComboBoxModel<>();
		seleccionarUsuario = new JComboBox<String>(modeloSeleccion);
		modeloSeleccion.addElement("Usuario");
		seleccionarUsuario.setBounds(45, 165, 385, 25);
		this.add(seleccionarUsuario);
		
		botonEditar = new JButton("Editar a ''");
		botonEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonEditar.setBounds(45, 200, 385, 30);
		this.add(botonEditar);
		
    	String [] columnas = {"Usuario","Nombre","Acciones"};
    	Object [][] filas = {{""}};
        DefaultTableModel model = new DefaultTableModel(filas,columnas);
        tablaUsuarios = new JTable(model);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        scrollPane.setBounds(45, 245, 386, 39);
        this.add(scrollPane);
        
        this.repaint();
	}
}
