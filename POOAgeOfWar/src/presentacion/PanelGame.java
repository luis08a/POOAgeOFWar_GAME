package presentacion;

import java.awt.*;
import javax.swing.*;

import aplicacion.Arena;
import aplicacion.*;



public class PanelGame extends JPanel implements Runnable{
	
	public static PanelGame pg = null;
	private Arena r;
	private final int height=Juego.ALTO*(4/5);
	private final int whidth=Juego.ANCHO;
	private Sprite[] sprites = new Sprite[20]; 
	private final Sprite[] bases = new Sprite[2];
	private Image fondo;
	private Thread thread;
	private Unidad[][] u = new Unidad[20][2];
	private volatile boolean enEjecución = true;
	
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
	 * Crea un Sprite (Dibujo) que serÃ¡ recreado en pantalla.
	 */
	public void createSprite(String name) {
		///
		Base b1= r.getBases(1);
		r.ponerUnidad(b1, "@");
		
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
        for (int i= 1; i< u.length -1; i++ ) {
        	if (u[i][0]!=null && u[i][0].getTipo().equals("vacio")==false ) {
        		Sprite m = new SpriteTest(u[i][0].getPosx(),u[i][0].getPosy()); 
	            g2d.drawImage(m.getImage(), m.getX(),m.getY(),80,80, this);
        	}
        	if (u[i][1]!=null && u[i][1].getTipo().equals("vacio")==false) {
        		Sprite n = new SpriteTest(u[i][0].getPosx(),u[i][0].getPosy()); 
	            g2d.drawImage(n.getImage(), n.getX(),n.getY(),80,80, this);
        	}
        } 
        
        Toolkit.getDefaultToolkit().sync();
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
	
	private void prepareArena(){
		r= Arena.creeArena();
		u = r.getArena();
		iniciar();
	}
	private void iniciar(){
		thread=new Thread(this,"actualiz");
		thread.start();
	}
	
	private void parar() {
		
	}
	
	private void actualizar(){
		r.actualizar();
		repaint();
	}
	public void  run(){
		while(enEjecución) {
			
		}
	}
}
