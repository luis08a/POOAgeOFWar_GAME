package presentacion;
import java.awt.*;
import javax.swing.*;

public class Sprite {
	protected int xPosition;
	protected int yPosition;
	private int height;
	private int width;
	private Image imagen;
	
	public Sprite(int x, int y){
		xPosition = x;
		yPosition = y;
	}
	
	public void loadImage(String source) {
		Image ii = new ImageIcon(getclass().getResource(source)).getImage();
	}
	
	public Image getImage() {
		return imagen;
	}
	
	public int getX() {
		return xPosition;
	}
	
	public int getY() {
		return yPosition;
	}
	
	public void move() {}
}
