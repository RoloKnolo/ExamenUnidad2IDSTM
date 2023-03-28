package menu;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class Principal extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Login pnlLogin;
	Registro pnlRegistro;
	JScrollPane scrollPaneles;
	JScrollPane scrollPaneljmb;
	Jmb menuBar;
	CuentaUsuario pnlCuentaUsuario;
	HolaUsuario pnlHolaUsuario;
	AyudaUsuario pnlAyudaUsuario;
	Tabla_usuarios pnlTablaUsuarios;
	JPanel Anterior, Actual, inicio;
	
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
		
		pnlLogin = new Login(this);
		pnlRegistro = new Registro(this);
		menuBar = new Jmb(this);
		pnlCuentaUsuario = new CuentaUsuario();
		pnlHolaUsuario = new HolaUsuario();
		pnlAyudaUsuario = new AyudaUsuario(this);
		pnlTablaUsuarios = new Tabla_usuarios();
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 20, 500, 480);

		scrollPaneljmb = new JScrollPane();
		scrollPaneljmb.setBounds(0, 0, 500, 22);
		
		this.add(scrollPaneles);
		this.add(scrollPaneljmb);
		
		definirPanelJmb(menuBar);
		//Aqui llamas al panel que quieres mostrar primero en la ventana
		definirPanel(pnlLogin);
		
		this.repaint();
		this.revalidate();
	}
	
	
	protected void definirPanelJmb(Jmb jmb) {
		scrollPaneljmb.setViewportView(menuBar);
	}
	protected void definirPanel(JPanel pnlLogin) {
		scrollPaneles.setViewportView(pnlLogin);
		Actual = pnlLogin;
	}
	protected void setPanelAnterior(JPanel a) {
		Anterior = a;
	}
}
