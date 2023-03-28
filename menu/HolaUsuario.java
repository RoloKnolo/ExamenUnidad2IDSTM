package menu;

import java.awt.*;

import javax.swing.*;

public class HolaUsuario extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JLabel lblNewLabel;
	Principal principal;
	private String usuario;
	public HolaUsuario() {
		this.setLayout(null);
		this.setVisible(true);
		showHolaUsuario();
	}

	private void showHolaUsuario() {
		usuario = "<Usuario>";
		lblNewLabel = new JLabel("Hola "+ usuario, SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
		lblNewLabel.setBounds(55, 35, 368, 44);
		this.add(lblNewLabel);
	}
}
