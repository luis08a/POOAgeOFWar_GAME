package presentacion;

import java.awt.*;
import javax.swing.*;

import aplicacion.Arena;
import aplicacion.*;



public class PanelGame extends JPanel{
	
	public static PanelGame pg = null;
	private Arena r;
	private final int height=Juego.ALTO*(3/4);
	private final int whidth=Juego.ANCHO;
	private Sprite[] sprites = new Sprite[20]; 
	private final Sprite[] bases = new Sprite[2];
	private Image fondo;
	private Base b1;
	private Base b2;
	
	private PanelGame() {
		setFocusable(true);
		
		setBackground(Color.white);
		setDoubleBuffered(true);
		//setSize(whidth,height);
		Arena r= prepareArena();
		this.setDoubleBuffered(true);
		b1=r.getBases(1);
		b2=r.getBases(2);
		
	}
	
	public void createSprite(String name) {
		//r.ponerUnidad(base, tipo);
		Sprite s = new SpriteTest(100,400);
		sprites[0] = s;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		fondo = new ImageIcon(getClass().getResource("/recursos visuales/bg.png")).getImage();
		g.drawImage(fondo, 0, 0, getSize().width, getSize().height-400, null);
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
	private Arena prepareArena(){
		Arena r=new Arena();
		return r;		
	}
	
	public static PanelGame getPanelGame() {
		if (pg==null) {
			pg = new PanelGame();
		}
		return pg;
	}
}
