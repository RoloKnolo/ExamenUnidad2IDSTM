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
	
	JLabel nombre, apellido, correo, contraseña,confi_contraseña, lblNewLabel;
	JTextField jtnombre, jtapellido, jcorreo;
	JPasswordField jcontraseña, jconfi_contraseña;
	JButton registrar, regresar;
	JSeparator separadorUp, separadorDown;
	
	private int xLabel = 29;
	private int yLabel = 135;
	private int xField = 100;
	private int yField = 135;
	
	public Registro() {
		this.setLayout(null);
		this.setVisible(true);
		showRegistro();
	}

	private void showRegistro() {
		
		lblNewLabel = new JLabel("REGISTRO", SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 50));
		lblNewLabel.setBounds(60, 45, 368, 44);
		this.add(lblNewLabel);
		
		separadorUp = new JSeparator();
		separadorUp.setBounds(10, xLabel+85, 466, 2);
		this.add(separadorUp);
		
		nombre = new JLabel("Nombre:",SwingConstants.CENTER);
		nombre.setForeground(SystemColor.controlText);
		nombre.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		nombre.setBounds(xLabel, yLabel, 70, 20);
		this.add(nombre);
		
		jtnombre = new JTextField();
		jtnombre.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jtnombre.setBounds(xField, yField, 167, 20);
		this.add(jtnombre);
		
		apellido = new JLabel("Apellido:",SwingConstants.CENTER);
		apellido.setForeground(SystemColor.controlText);
		apellido.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		apellido.setBounds(xLabel, yLabel+=35, 70, 20);
		this.add(apellido);
		
		jtapellido = new JTextField();
		jtapellido.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jtapellido.setBounds(xField, yField+=35, 167, 20);
		this.add(jtapellido);
		
		correo = new JLabel("Correo:",SwingConstants.CENTER);
		correo.setForeground(SystemColor.controlText);
		correo.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		correo.setBounds(xLabel+3, yLabel+=35, 70, 20);
		this.add(correo);
		
		jcorreo = new JTextField();
		jcorreo.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jcorreo.setBounds(xField, yField+=35, 167, 20);
		this.add(jcorreo);
		
		contraseña = new JLabel("Contraseña:",SwingConstants.LEFT);
		contraseña.setForeground(SystemColor.controlText);
		contraseña.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		contraseña.setBounds(xLabel, yLabel+=35, 110, 20);
		this.add(contraseña);
		
		jcontraseña = new JPasswordField();
		jcontraseña.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jcontraseña.setBounds(xField+27, yField+=35, 167, 20);
		this.add(jcontraseña);
		
		contraseña = new JLabel("Confirme su contraseña:",SwingConstants.LEFT);
		contraseña.setForeground(SystemColor.controlText);
		contraseña.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		contraseña.setBounds(xLabel, yLabel+=35, 190, 20);
		this.add(contraseña);
		
		jcontraseña = new JPasswordField();
		jcontraseña.setFont(new Font("Calisto MT", Font.BOLD, 15));
		jcontraseña.setBounds(xField+122, yField+=35, 167, 20);
		this.add(jcontraseña);
		
//		terminos = new JCheckBox("Acepta los terminos y condiciones.");
//		terminos.setForeground(SystemColor.GRAY);
//		terminos.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
//		terminos.setBounds(xLabel+75, yLabel+=35, 250, 20);
//		this.add(terminos);
		
		separadorDown = new JSeparator();
		separadorDown.setBounds(10, yLabel+40, 466, 2);
		this.add(separadorDown);
		
		
		registrar = new JButton("Crar cuenta");
		registrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		registrar.setBounds(xLabel+300, yLabel+70, 120, 30);
		this.add(registrar);
		
		registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nombre.getText();
				String lastname = apellido.getText();
				String email = jcorreo.getText();
				String pswrd = new String(jcontraseña.getPassword());
				

				FileWriter writer ;
				
				try {
					 writer = new FileWriter("users.txt",true);
					 
					 PrintWriter linea = new PrintWriter(writer);
					 
					 linea.println(nombre+","+apellido+","+email+","+pswrd);  
					 
					 linea.close();
					 writer.close();
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		regresar = new JButton("Regresar");
		regresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		regresar.setBounds(xLabel, yLabel+70, 120, 30);
		this.add(regresar);
		regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.repaint();
	}
}
