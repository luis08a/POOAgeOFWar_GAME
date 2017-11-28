package presentacion;

import java.awt.*;
import javax.swing.*;

public class panelGame extends JPanel {
	private int height;
	private int whidt;
	private Sprite[] sprites = new Sprite[20]; 
	
	public panelGame() {
		setFocusable(true);
		
		setBackground(Color.white);
		setDoubleBuffered(true);
	}
	
	public void createSprite(String name,int x, int y) {
		Sprite s = new SpriteTest(x,y);
		sprites[0] = s;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for ( Sprite m : sprites) {
        	if (m!=null) {
	            g2d.drawImage(m.getImage(), m.getX(),
	                    m.getY(), this);
        	}
        } 
        Toolkit.getDefaultToolkit().sync();
	}
	
}
