package presentacion;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import aplicacion.*;

public class PanelGame extends JPanel implements Runnable{
	
	public static PanelGame pg = null;
	private Arena r;
	private final int HEIGHT=Juego.ALTO*4/5;
	private final int WIDTH=Juego.ANCHO;
	private final Image fondo = new ImageIcon(getClass().getResource("/recursos visuales/1.png")).getImage();
	private Thread thread;
	private Unidad[][] u ;
	private volatile boolean enEjecucion;
	private boolean isIA;
	private Jugador J1;
	private Jugador J2;
	/*
	 * Constructor
	 */
	private PanelGame(String tipoIA) {
		setFocusable(true);
		setBackground(Color.white);
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		prepareArena();
		if (tipoIA!=null){			
			r.jugadorVsIA(tipoIA);
			J2=  r.getJ2();			
			isIA=true;
		}
		else if( tipoIA == null){
			r.jugadorVsJugador();
			J2=r.getJ2();
			isIA=false;
		}
		
		J1=r.getJ1();
		
		iniciar();
	}
		
	public void crearSoldadoMelee(int Jugador) throws PAOWException  {
		if (Jugador == 1) {Unidad u =J1.crearSoldadoMelee();
		Base b=J1.getBase();
		r.ponerUnidad(b, u);
		}
		else if(Jugador ==2 ){Unidad u = J2.crearSoldadoMelee();Base b=J2.getBase();r.ponerUnidad(b, u);}
	}
	
	public void crearSoldadoTanque(int Jugador ) throws PAOWException {
		if (Jugador == 1) {Unidad u =J1.crearSoldadoTanque();Base b=J1.getBase();r.ponerUnidad(b, u);}
		else if(Jugador ==2 ){Unidad u =J2.crearSoldadoTanque();Base b=J2.getBase();r.ponerUnidad(b, u);}
	}
	
	public void avanzarEra(int Jugador ) throws PAOWException{
		if (Jugador == 1) {J1.avanzarEra();}
		else if(Jugador ==2 ){J2.avanzarEra();}
	}
	
	public int getEra(int jugador){
		return r.getBase(jugador).getEra();
	}
	
	public  void obtenerDinero(){
		int d1=r.obtDinero(1);
		int v1=r.getBase(1).getVida();		
		if (!isIA) {
			int d2=r.obtDinero(2);
			int v2=r.getBase(2).getVida();
			Juego.actualizLabels(d1,d2,v1,v2);
		}
		else {
		
		Juego.actualizLabels(d1,v1);}
		
	}
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(fondo, 0, 0, getSize().width, getSize().height, null);
		
		Sprite torre1 = new Sprite(r.getBase(1));
		g.drawImage(torre1.getImage(), 0, 350, 80, 120, this);
		
		Sprite torre2 = new Sprite(r.getBase(2));
		g.drawImage(Sprite.flip(torre2.getImage()), WIDTH - 80, 350, 80, 120, null);
		
		//Crear unidad
        Graphics2D g2d = (Graphics2D) g;
        for (int i= 1; i< u.length -1; i++ ) {
        	
        	if (u[i][0]!=null ) {
        		Sprite m = new Sprite(u[i][0]); 
	            g2d.drawImage(m.getImage(), m.getX(),m.getY(),80,80, this);
        	}
        	if (u[i][1]!=null ) {
        		Sprite n = new Sprite(u[i][1]);
	            g2d.drawImage(Sprite.flip(n.getImage()), n.getX(),n.getY(),80,80, this);
        	}
        }
        Toolkit.getDefaultToolkit().sync();
	}
	
	/*
	 * Crea una única instancia de PanelGame.
	 */
	public static PanelGame getPanelGame(String tipoIA) {
		if (pg==null) {
			pg = new PanelGame(tipoIA);
		}
		return pg;
	}
	
	/*
	 * Crea una instancia de la clase Arena, inicialmente vacia.
	 */
	private void prepareArena(){
		r= Arena.creeArena();
		u = r.getArena();
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
		
		try {
			if (isIA==true)J2.desicion(r);
			r.actualizar();
			obtenerDinero();
		} catch (PAOWException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			r.reiniciarArena();
			POOAgeOfWarGUI.cargarMenu();
			parar();
			
		}
		repaint();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void  run(){
		while(enEjecucion) {
			try {
				Thread.sleep(200);
				actualizar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void guardar(File f) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(J1);
		out.writeObject(J2);
		out.writeObject(r);
		out.writeObject(u);
		out.close();
	}
	
	public void abrir(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		J1 = (Jugador)in.readObject();
		J2 = (Jugador)in.readObject();
		r = (Arena)in.readObject();
		u = (Unidad[][]) in.readObject();
		in.close();
	}
}
