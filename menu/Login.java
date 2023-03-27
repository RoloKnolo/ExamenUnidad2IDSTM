package menu;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Login extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2;
	JTextField textField;
	JPasswordField passwordField;
	JButton btnExit, btnNewButton, btnLogin;
	JSeparator separator, separator_1;
	
	public Login() {
		 
		this.setLayout(null);
		this.setVisible(true);
		showLogin();
		
	}
	private void showLogin() {
		
		lblNewLabel = new JLabel("ACCEDER");
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 50));
		lblNewLabel.setBounds(120, 60, 368, 44);
		this.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre de usuario");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1.setBounds(150, 170, 140, 24);
		this.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contraseña de acceso");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_2.setBounds(150, 230, 170, 31);
		this.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(150, 200, 175, 25);
		textField.setColumns(10);
		this.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(150, 260, 175, 25);
		this.add(passwordField);
		
		
		btnExit = new JButton("CANCELAR");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(50, 350, 132, 31);
		this.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		btnLogin = new JButton("INISIAR SESION");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(300, 350, 132, 31);
		this.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
				String pswrd = new String(passwordField.getPassword());
				BufferedReader reader;
				
				Boolean flag = false;
				
				try {

					FileReader file = new FileReader("registrosUsuarios.txt");
					reader = new BufferedReader(file);
					
					String line = reader.readLine();
					
					while(line != null) {
						
						String data [] = line.split(",");
						 
						if( email.equals(data[2]) ) {
							if( pswrd.equals(data[3]) ) {
								flag = true;
							}
						} 
						
						line = reader.readLine();
						
					}
					
					if(flag) {
						JOptionPane.showMessageDialog(null,"Correcto","Bienvenido al sistema", JOptionPane.INFORMATION_MESSAGE );
					}else {
						JOptionPane.showMessageDialog(null,"Error","Fuera Perro!", JOptionPane.ERROR_MESSAGE );
					}
					
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		separator = new JSeparator();
		separator.setBounds(10, 145, 466, 2);
		this.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 310, 466, 2);
		this.add(separator_1);
		
		this.repaint();
	}
}
