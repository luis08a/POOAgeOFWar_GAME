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
		imagen = new ImageIcon(getClass().getResource(source)).getImage();
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
	
	/*
	*
	*/
	public static BufferedImage toBufferedImage(Image img){
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();
	    return bimage;
	}
}
