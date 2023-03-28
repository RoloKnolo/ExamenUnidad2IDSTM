package menu;
import javax.swing.*;

public class Imageninicio{
	 {

	        JFrame frame = new JFrame();
	        ImageIcon image = new ImageIcon("src/menu/ImagenInicio.png");
	        JLabel label = new JLabel(image);
	        frame.add(label);
	        frame.setUndecorated(true); // quitar bordes de la ventana
	        frame.pack();
	        frame.setLocationRelativeTo(null); // centrar la ventana
	        frame.setVisible(true);
	        
	       
	        
	        
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // mostrar la imagen durante 3 segundos (3000 milisegundos)
	        
	        frame.dispose(); // cerrar la ventana
	        // continuar con el resto del programa
	    }
}
