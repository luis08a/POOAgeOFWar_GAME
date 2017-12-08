package presentacion;
import java.awt.*;
import javax.swing.*;

public class Fondo extends JPanel{
	private String ruta;
	
	public Fondo(String resource) {
		ruta = resource;
	}
	public void paint(Graphics g) {
		Dimension height = getSize();				 
		Image i = new ImageIcon(getClass().getResource(ruta)).getImage();
		g.drawImage(i, 0, 0, height.width, height.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
