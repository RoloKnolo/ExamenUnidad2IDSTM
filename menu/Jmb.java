package menu;

import javax.swing.*;

public class Jmb extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public Jmb() {
		this.setLayout(null);
		this.setVisible(true);
		showJmb();
	}

	private void showJmb() {
		JMenuBar jmb = new JMenuBar();
		jmb.setLocation(0, 0);
		jmb.setSize(500, 20);
		this.add(jmb);
		
		JMenu jm1 = new JMenu("Cuenta");
		JMenu jm2 = new JMenu("Usuarios");
		JMenu jm3 = new JMenu("Ayuda");
		
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		
		JMenuItem jmi1 = new JMenuItem("Mi cuenta");
		JMenuItem jmi12 = new JMenuItem("Cerrar sesion");
		
		jm1.add(jmi1);
		jm1.add(jmi12);
		
		JMenuItem jmi2 = new JMenuItem("Lista de usuarios");
		JMenuItem jmi22 = new JMenuItem("Crear usuario");
		
		jm2.add(jmi2);
		jm2.add(jmi22);
		
		JMenuItem jmi3 = new JMenuItem("¿Como crear usuarios?");
		
		jm3.add(jmi3);
		
		this.repaint();
	}
}
