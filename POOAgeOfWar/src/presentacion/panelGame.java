package presentacion;

import java.awt.*;
import javax.swing.*;



public class panelGame extends JPanel{
	 private final int height=Juego.alto*(3/4);
	  private final int whidth=Juego.ancho;
	private Sprite[] sprites = new Sprite[20]; 
	private final Sprite[] bases = new Sprite[2];
	private Image fondo;
	
	public panelGame() {
		setFocusable(true);
		
		setBackground(Color.white);
		setDoubleBuffered(true);
		//setSize(whidth,height);
	}
	
	public void createSprite(String name) {
		Sprite s = new SpriteTest(100,400);
		sprites[0] = s;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		fondo = new ImageIcon(getClass().getResource("/recursos visuales/rock.png")).getImage();
		Dimension height = getSize();
		//g.drawImage(fondo, 0, 0, height.width, height.height-400, null);
		Image torre1 = new ImageIcon(getClass().getResource("/recursos visuales/tower-drawing/Tower.png")).getImage();
		g.drawImage(torre1, 0, 350, 80, 120, this);
		
		//Crear unidad
        Graphics2D g2d = (Graphics2D) g;
        for ( Sprite m : sprites) {
        	if (m!=null) {
	            g2d.drawImage(m.getImage(), m.getX(),m.getY(),80,80, this);
        	}
        } 
        
        Toolkit.getDefaultToolkit().sync();
	}
	
}
