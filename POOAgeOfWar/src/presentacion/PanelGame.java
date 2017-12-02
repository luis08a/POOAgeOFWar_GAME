package presentacion;

import java.awt.*;
import javax.swing.*;

import aplicacion.Arena;
import aplicacion.*;



public class PanelGame extends JPanel{
	
	public static PanelGame pg = null;
	private Arena r;
	private final int height=Juego.ALTO*(4/5);
	private final int whidth=Juego.ANCHO;
	private Sprite[] sprites = new Sprite[20]; 
	private final Sprite[] bases = new Sprite[2];
	private Image fondo;
	
	/*
	 * Constructor
	 */
	private PanelGame() {
		setFocusable(true);
		setBackground(Color.white);
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(height,whidth));
		prepareArena();
	}
	
	/*
	 * Crea un Sprite (Dibujo) que será recreado en pantalla.
	 */
	public void createSprite(String name) {
		Sprite s = new SpriteTest(100,400);
		sprites[0] = s;
		repaint();
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		fondo = new ImageIcon(getClass().getResource("/recursos visuales/bg.png")).getImage();
		g.drawImage(fondo, 0, 0, getSize().width, getSize().height, null);
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
	
	
	private void prepareArena(){
		r= Arena.creeArena();
	}
	
	/*
	 * Crea una única instancia de PanelGame.
	 */
	public static PanelGame getPanelGame() {
		if (pg==null) {
			pg = new PanelGame();
		}
		return pg;
	}
}
