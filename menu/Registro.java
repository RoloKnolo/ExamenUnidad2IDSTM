package menu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class Registro extends JPanel{
	private static final long serialVersionUID = 1L;
	
	JLabel nombre, usuario, correo, contrasena,confi_contrasena, lblNewLabel;
	JTextField jtnombre, jtusuario, jcorreo;
	JPasswordField jcontrasena, jconfi_contrasena;
	JButton registrar, regresar;
	JSeparator separadorUp, separadorDown;
	Principal principal;
	
	private int xLabel = 150;
	private int yLabel = 125;
	private int xField = 150;
	private int yField = 150;
	
	public Registro(Principal p) {
		principal = p;
		this.setLayout(null);
		this.setVisible(true);
		showRegistro();
	}

	private void showRegistro() {
		
		lblNewLabel = new JLabel("CREAR USUARIO", SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 42));
		lblNewLabel.setBounds(55, 35, 368, 44);
		this.add(lblNewLabel);
		
		separadorUp = new JSeparator();
		separadorUp.setBounds(10, xLabel-45, 466, 2);
		this.add(separadorUp);
		
		nombre = new JLabel("Nombre:",SwingConstants.CENTER);
		nombre.setForeground(SystemColor.controlText);
		nombre.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		nombre.setBounds(xLabel, yLabel, 70, 20);
		this.add(nombre);
		
		jtnombre = new JTextField();
		jtnombre.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jtnombre.setBounds(xField, yField, 180, 20);
		this.add(jtnombre);
		
		usuario = new JLabel("Usuario:",SwingConstants.CENTER);
		usuario.setForeground(SystemColor.controlText);
		usuario.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		usuario.setBounds(xLabel, yLabel+=45, 70, 20);
		this.add(usuario);
		
		jtusuario = new JTextField();
		jtusuario.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jtusuario.setBounds(xField, yField+=45, 180, 20);
		this.add(jtusuario);
		
		correo = new JLabel("Email:",SwingConstants.CENTER);
		correo.setForeground(SystemColor.controlText);
		correo.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		correo.setBounds(xLabel-10, yLabel+=45, 70, 20);
		this.add(correo);
		
		jcorreo = new JTextField();
		jcorreo.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jcorreo.setBounds(xField, yField+=45, 180, 20);
		this.add(jcorreo);
		
		contrasena = new JLabel("contrasena:",SwingConstants.LEFT);
		contrasena.setForeground(SystemColor.controlText);
		contrasena.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		contrasena.setBounds(xLabel, yLabel+=45, 110, 20);
		this.add(contrasena);
		
		jcontrasena = new JPasswordField();
		jcontrasena.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jcontrasena.setBounds(xField, yField+=45, 180, 20);
		this.add(jcontrasena);
		
		confi_contrasena = new JLabel("Confirmar contrasena:",SwingConstants.LEFT);
		confi_contrasena.setForeground(SystemColor.controlText);
		confi_contrasena.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		confi_contrasena.setBounds(xLabel, yLabel+=45, 180, 20);
		this.add(confi_contrasena);
		
		jconfi_contrasena = new JPasswordField();
		jconfi_contrasena.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jconfi_contrasena.setBounds(xField, yField+=45, 180, 20);
		this.add(jconfi_contrasena);
		
		separadorDown = new JSeparator();
		separadorDown.setBounds(10, yLabel+65, 466, 2);
		this.add(separadorDown);
		
		
		registrar = new JButton("Crear usuario");
		registrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		registrar.setBounds(xLabel+180, yLabel+85, 120, 30);
		this.add(registrar);
		
		registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nombre.getText();
				String lastname = usuario.getText();
				String email = jcorreo.getText();
				String pswrd = new String(jcontrasena.getPassword());
				
	           

				if (e.getSource() == registrar) {

		            // Validar que los campos no estén vacíos
		            if (name.isEmpty() || lastname.isEmpty() || email.isEmpty() || pswrd.isEmpty()|| !validarContra()) {
		                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            if (!name.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && validarContra()) {
		                JOptionPane.showMessageDialog(null, "Registro Exitoso", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);

		            }
				
		            try {
		 
		                FileReader lectorArchivo = new FileReader("registrosUsuarios.txt");
		                BufferedReader bufferLector = new BufferedReader(lectorArchivo);

		            
		                StringBuilder contenidoArchivo = new StringBuilder();
		                String lineaActual = bufferLector.readLine();
		                while (lineaActual != null) {
		                    contenidoArchivo.append(lineaActual);
		                    contenidoArchivo.append(System.lineSeparator()); 
		                    lineaActual = bufferLector.readLine();
		                }

		                bufferLector.close();
		                lectorArchivo.close();
		            } catch (IOException e3) {
		                e3.printStackTrace();
		            }
		}}});
		
		regresar = new JButton("Cancelar");
		regresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		regresar.setBounds(xLabel-120, yLabel+85, 120, 30);
		this.add(regresar);
		regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				{JPanel a = principal.Actual;
				principal.definirPanel(principal.Anterior);
				principal.setPanelAnterior(a);
				
				}	
				
			}
		});
		this.repaint();
	}
	private boolean validarContra() {
		if (String.valueOf(jcontrasena.getPassword()).equals(String.valueOf(jconfi_contrasena.getPassword())))
			return true;
		return false;
	}
}
