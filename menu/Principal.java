package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Principal extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Login pnlLogin;
	Registro pnlRegistro;
	JScrollPane scrollPaneles;
	
	public Principal(){ 
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		mostrarComponentes();
	}
	
	private void mostrarComponentes() {
		
		pnlLogin = new Login();
		pnlRegistro = new Registro();
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 500, 680);
		
//		JMenuBar jmb = new JMenuBar();
//		jmb.setLocation(0, 0);
//		jmb.setSize(500, 20);
//		this.add(jmb);
//		
//		JMenu jm1 = new JMenu("Menu");
//		
//		jmb.add(jm1);
//		
//		JMenuItem jmi1 = new JMenuItem("Login");
//		JMenuItem jmi2 = new JMenuItem("Registro");
//		
//		jm1.add(jmi1);
//		jm1.add(jmi2);
		
		this.add(scrollPaneles);
		
		definirPanel(pnlLogin);
		this.repaint();
		this.revalidate();
	}
	
	private void definirPanel(Login pnLogin) {
		scrollPaneles.setViewportView(pnLogin);
	}
	
//	private void definirPanel(Registro pnRegistro) {
//		scrollPaneles.setViewportView(pnRegistro);
//	}

}
