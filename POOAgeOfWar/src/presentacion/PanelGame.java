package presentacion;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.*;

import aplicacion.*;

public class PanelGame extends JPanel implements Runnable{
	
	public static PanelGame pg = null;
	private Arena r;
	private final int HEIGHT=Juego.ALTO*4/5;
	private final int WIDTH=Juego.ANCHO;
	private Image fondo = new ImageIcon(getClass().getResource("/recursos visuales/1.png")).getImage();;
	private Thread thread;
	private Unidad[][] u ;
	private volatile boolean enEjecucion;
	private boolean JCJ;
	
	
	/*
	 * Constructor
	 */
	private PanelGame() {
		setFocusable(true);
		setBackground(Color.white);
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		prepareArena();
		
		iniciar();
	}
	
	/*
	 * Crea un Sprite (Dibujo) que será recreado en pantalla.
	 */
	public void createSprite(String name,int num) {
		Base b= r.getBase(num);
		try {
			r.ponerUnidad(b, "@");
		} catch (PAOWException e) {
			//e.printStackTrace();
		}
		repaint();
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(fondo, 0, 0, getSize().width, getSize().height, null);
		
		Image torre1 = new ImageIcon(getClass().getResource("/recursos visuales/tower-drawing/Tower.png")).getImage();
		g.drawImage(torre1, 0, 350, 80, 120, this);
		
		Image torre2 = new ImageIcon(getClass().getResource("/recursos visuales/tower-drawing/Tower.png")).getImage();
		g.drawImage(torre2, WIDTH - 80, 350, 80, 120, null);
		
		//Crear unidad
        Graphics2D g2d = (Graphics2D) g;
        for (int i= 1; i< u.length -1; i++ ) {
        	
        	if (u[i][0]!=null ) {
        		Sprite m = new SpriteTest(u[i][0].getPosx(),u[i][0].getPosy()); 
	            g2d.drawImage(m.getImage(), m.getX(),m.getY(),80,80, this);
        	}
        	
        	if (u[i][1]!=null ) {
        		Sprite n = new SpriteTest(u[i][1].getPosx(),u[i][1].getPosy());
        		Image im = n.getImage();
        		
        		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        		tx.translate(-im.getWidth(null), 0);
        		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        		
        		BufferedImage ima = Sprite.toBufferedImage(im);
        		Image image = op.filter(ima, null);
	            g2d.drawImage(image, n.getX(),n.getY(),80,80, this);
        	}
        	
        } 
        
        Toolkit.getDefaultToolkit().sync();
        
	}
	
	public BufferedImage flipHorizontal(BufferedImage src){
	     AffineTransform tx=AffineTransform.getScaleInstance(1.0,-1.0);  //scaling
	     tx.translate(0,-src.getHeight());  //translating
	     AffineTransformOp tr=new AffineTransformOp(tx,null);  //transforming
	     
	     return tr.filter(src, null);  //filtering
	    }
	
	/*
	 * Crea una única instancia de PanelGame.
	 */
	public static PanelGame getPanelGame(boolean jcj) {
		if (pg==null) {
			pg = new PanelGame();
		}
		return pg;
	}
	
	/*
	 * Crea una instancia de la clase Arena, inicialmente vacia.
	 */
	private void prepareArena(){
		r= Arena.creeArena();
		u = r.getArena();
		//r.enemyIAIngenuo();
		iniciar();
	}
	
	/*
	 * Inicia el hilo de actualización de la pantalla
	 */
	private void iniciar(){
		enEjecucion =true;
		
		thread=new Thread(this,"actualiz");
		thread.start();
	}
	
	/*
	 * Detiene el hilo de actualización
	 */
	public void parar() {
		try {
			thread.join();
			enEjecucion = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Actualiza la pantalla y la arena.
	 */
	private synchronized void actualizar(){
		r.actualizar();
		repaint();
		//r.enemyIAIngenuo();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void  run(){
		while(enEjecucion) {
			try {
				Thread.sleep(1000);
				actualizar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
