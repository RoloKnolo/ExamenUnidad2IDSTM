package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AyudaUsuario extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JLabel lblNewLabel, info;
	JButton crearUsuario;
	Principal principal;
	private String texto = "<html>1. Hacer click en la opci�n \"Usuarios\" en " + 
			"el men� superior.<p>" + 
			"2. Hacer click en la opci�n \"Crear " + 
			"Usuario\" en el men� desplegado.<p>" + 
			"3. Llenar los campos solicitados.<p>" + 
			"4. Escribri una peque�a descripci�n de ti.<p>" + 
			"5. Seleccionar tu comida favorita.<p>" + 
			"6. Seleccionar tu color favorito.<p>" + 
			"7. Hacer click en el bot�n \"Crear " + 
			"Usuario\".<p>" + 
			"8. Listo, el usuario se ha creado.<html>";
	
	public AyudaUsuario(Principal p) {
		principal = p;
		this.setLayout(null);
		this.setVisible(true);
		showAyuda();
	}

	private void showAyuda() {
		
		lblNewLabel = new JLabel("�COMO CREAR UN USUARIO?", SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
		lblNewLabel.setBounds(30, 35, 415, 44);
		this.add(lblNewLabel);
		
		info = new JLabel(texto,SwingConstants.LEFT);
		info.setForeground(SystemColor.controlText);
		info.setFont(new Font("Source Sans Pro", Font.BOLD, 17));
		info.setBounds(70, 100, 335, 245);
		info.setOpaque(true);
		info.setBackground(Color.decode("#bbbbbb"));
		this.add(info);
		
		crearUsuario = new JButton("Crear un usuario ahora");
		crearUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		crearUsuario.setBounds(130,370, 220, 30);
		this.add(crearUsuario);
		
		crearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.setPanelAnterior(principal.Actual);
				principal.definirPanel(principal.pnlRegistro);
			}
		});
		
	}
}
