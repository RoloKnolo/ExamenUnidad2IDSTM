package menu;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class Registro extends JPanel{
	private static final long serialVersionUID = 1L;
	
	JLabel nombre, usuario, correo, contraseña,confi_contraseña, lblNewLabel;
	JTextField jtnombre, jtusuario, jcorreo;
	JPasswordField jcontraseña, jconfi_contraseña;
	JButton registrar, regresar;
	JSeparator separadorUp, separadorDown;
	
	private int xLabel = 150;
	private int yLabel = 125;
	private int xField = 150;
	private int yField = 150;
	
	public Registro() {
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
		
		contraseña = new JLabel("Contraseña:",SwingConstants.LEFT);
		contraseña.setForeground(SystemColor.controlText);
		contraseña.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		contraseña.setBounds(xLabel, yLabel+=45, 110, 20);
		this.add(contraseña);
		
		jcontraseña = new JPasswordField();
		jcontraseña.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jcontraseña.setBounds(xField, yField+=45, 180, 20);
		this.add(jcontraseña);
		
		confi_contraseña = new JLabel("Confirmar contraseña:",SwingConstants.LEFT);
		confi_contraseña.setForeground(SystemColor.controlText);
		confi_contraseña.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		confi_contraseña.setBounds(xLabel, yLabel+=45, 180, 20);
		this.add(confi_contraseña);
		
		jconfi_contraseña = new JPasswordField();
		jconfi_contraseña.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jconfi_contraseña.setBounds(xField, yField+=45, 180, 20);
		this.add(jconfi_contraseña);
		
		separadorDown = new JSeparator();
		separadorDown.setBounds(10, yLabel+65, 466, 2);
		this.add(separadorDown);
		
		
		registrar = new JButton("Crar usuario");
		registrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		registrar.setBounds(xLabel+180, yLabel+85, 120, 30);
		this.add(registrar);
		
		registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nombre.getText();
				String lastname = usuario.getText();
				String email = jcorreo.getText();
				String pswrd = new String(jcontraseña.getPassword());
				

				FileWriter writer ;
				
				try {
					 writer = new FileWriter("users.txt",true);
					 
					 PrintWriter linea = new PrintWriter(writer);
					 
					 linea.println(nombre+","+usuario+","+email+","+pswrd);  
					 
					 linea.close();
					 writer.close();
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		regresar = new JButton("Cancelar");
		regresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		regresar.setBounds(xLabel-120, yLabel+85, 120, 30);
		this.add(regresar);
		regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.repaint();
	}
}
