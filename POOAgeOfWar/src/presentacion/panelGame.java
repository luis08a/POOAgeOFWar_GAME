package presentacion;

import java.awt.*;
import javax.swing.*;



public class panelGame extends JPanel{
	private int height;
	private int whidth;
	private Sprite[] sprites = new Sprite[20]; 
	private final Sprite[] bases = new Sprite[2];
	private Image fondo;
	
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
		fondo = new ImageIcon(getClass().getResource("/recursos visuales/background3-720.png")).getImage();
		Dimension height = getSize();
		g.drawImage(fondo, 0, 0, height.width, height.height, null);
		Image torre1 = new ImageIcon(getClass().getResource("/recursos visuales/tower-drawing/Tower.png")).getImage();
		g.drawImage(torre1, 0, 200, 80, 120, null);
		
		//Crear unidad
        Graphics2D g2d = (Graphics2D) g;
        for ( Sprite m : sprites) {
        	if (m!=null) {
	            g2d.drawImage(m.getImage(), m.getX(),m.getY(), this);
        	}
        } 
        
        Toolkit.getDefaultToolkit().sync();
	}
	
}
