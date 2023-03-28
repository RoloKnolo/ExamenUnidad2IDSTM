package menu;

import java.awt.Graphics;
import javax.swing.*;

public class MostrarImagen extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public MostrarImagen() {
		this.setLayout(null);
		this.setVisible(true);
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        ImageIcon img = new ImageIcon(getClass().getResource("menu/ImagenInicio.png")); 
        
        int x = (getWidth() - img.getIconWidth()) / 2;
        int y = (getHeight() - img.getIconHeight()) / 2;
        
        g.drawImage(img.getImage(), x, y, 350, 350, null);
        this.setOpaque(true);
    }
}
