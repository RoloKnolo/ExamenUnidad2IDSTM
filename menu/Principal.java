package menu;

import javax.swing.*;

public class Principal extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Login pnlLogin;
	Registro pnlRegistro;
	JScrollPane scrollPaneles;
	JScrollPane scrollPaneljmb;
	Jmb menuBar;
	
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
		menuBar = new Jmb();
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 20, 500, 480);
		
		scrollPaneljmb = new JScrollPane();
		scrollPaneljmb.setBounds(0, 0, 500, 22);
		
		this.add(scrollPaneles);
		this.add(scrollPaneljmb);
		
		definirPanelJmb(menuBar);
		//Aqui llamas al panel que quieres mostrar primero en la ventana
		definirPanel(pnlRegistro);
		
		this.repaint();
		this.revalidate();
	}
	
	private void definirPanelJmb(Jmb jmb) {
		scrollPaneljmb.setViewportView(menuBar);
	}
	
	private void definirPanel(Login pnLogin) {
		scrollPaneles.setViewportView(pnLogin);
	}
	
	private void definirPanel(Registro pnRegistro) {
		scrollPaneles.setViewportView(pnRegistro);
	}
}
