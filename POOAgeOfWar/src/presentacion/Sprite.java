package presentacion;
import java.awt.*;
import javax.swing.*;

public abstract class Sprite extends JPanel {
	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private Image imagen;
	
	public Sprite(int alto, int ancho){
		height = alto;
		width = ancho;
		setSize(width,height);
	}
	
	protected void paintComponent(Graphics g){
		//imagen = new ImageIcon(getClass().getResource(arg0)).getImage();
		//g.drawImage(arg0, arg1, arg2, arg3);
	}
}
