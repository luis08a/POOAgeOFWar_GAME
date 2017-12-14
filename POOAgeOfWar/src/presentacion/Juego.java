package presentacion;
import java.awt.*;
import javax.swing.*;

import aplicacion.PAOWException;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Juego extends JFrame {
	private boolean jcj;
	//Elementos Menú barra
	private JPanel panelOpciones;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem menuSalir;
	//Elementos panel opciones
	private JButton botonBack;
	//Elementos del panel de opciones para el Jugador 1.
	private JPanel J1;
	private JButton botonEvolve1;
	private JButton botonA;
	private JButton botonS;
	private JButton botonD;
	//Elementos del panel de opciones para el Jugador 2.
	private JPanel J2;
	private JButton botonEvolve2;
	private JButton botonJ;
	private JButton botonK;
	//Elementos Tablero de Juego
	private PanelGame tablero;
	public static final int ALTO=700;
	public static final int ANCHO=1300;
	private String tipoIA;
	private static JTextField cantOroJ1;
	private JTextField eraNumJ1;
	private JTextField eraNumJ2;
	private static JTextField cantOroJ2;
	private static JTextField cantvidaJ1;
	
	/*
	 * Constructor
	 */
	public Juego(String tipIA) {
		tipoIA=tipIA;
		jcj = false;
		prepareElementos();
		prepareAcciones();
		setVisible(true);
		setFocusable(true);
	}
	
	/*
	 * Constructor
	 */
	public Juego (){
		jcj =true;
		prepareElementos();
		prepareAcciones();
		setVisible(true);
		setFocusable(true);
	}
	
	
	/*
	 * Prepara los elementos necesarios para le interfaz. 
	 */
	private void prepareElementos(){
		setSize(ANCHO,ALTO);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		preparePanelOpciones();
		prepareElementosMenu();
		prepareTableroJuego();
	}
	
	/*
	 * Prepara los elementos necesarios para el Panel de opciones del jugador.
	 */
	private void preparePanelOpciones(){
		panelOpciones = new JPanel();
		int xEsquina = ANCHO;
		int yEsquina = ALTO/5;
		panelOpciones.setPreferredSize(new Dimension(xEsquina, yEsquina));
		panelOpciones.setLayout(new GridLayout(1,3));
		
		panelJ1();
		prepareAccionesJ1();
		panelOpciones.add(J1);
		if(jcj==true) {
			panelJ2();
			prepareAccionesJ2();
			panelOpciones.add(J2);
		}
		add(panelOpciones, BorderLayout.SOUTH);
	}
	
	/*
	 * Prepara los elementos del panel de acciones para el primer Jugador
	 */
	private void panelJ1() {
		J1 = new JPanel();
		J1.setLayout(new GridLayout(1,2));
		J1.setBounds(0, 600, 400, 100);
		
		JPanel state = new JPanel();
		state.setLayout(new GridLayout(2,1));
		
		JPanel state1 = new JPanel();
		state1.setLayout(new GridLayout(2,2));
		JLabel labelOro = new JLabel("Oro:");
		cantOroJ1=new JTextField( "100");
		cantOroJ1.setFocusable(false);
		eraNumJ1=new JTextField("1");
		eraNumJ1.setFocusable(false);
		JLabel labelDesarrollo = new JLabel("Nivel de desarrollo:");
		state1.add(labelOro);
		state1.add(cantOroJ1);
		state1.add(labelDesarrollo);
		
		state1.add(eraNumJ1);
		state.add(state1);
		
		botonEvolve1 = new JButton("Avanzar era (E)");
		state.add(botonEvolve1);
		
		JPanel action = new JPanel();
		action.setLayout(new GridLayout(2,1));
		JLabel vida = new JLabel(" vida: ");
		 cantvidaJ1=new  JTextField (" 10");
		 cantvidaJ1.setFocusable(false);
		 
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2,1));
		p.add(vida);
		p.add(cantvidaJ1);
		action.add(p);
		
		JPanel action1 = new JPanel();
		action1.setLayout(new GridLayout(1,3));
		botonA = new JButton("Unidad 1(A)");
		botonS = new JButton("Unidad 2(S)");
		botonD = new JButton("Unidad 3(D)");
		action1.add(botonA);
		action1.add(botonS);
		action1.add(botonD);
		action.add(action1);
		
		J1.add(state);
		J1.add(action);
	}
	
	/*
	 * Prepara los elementos del panel de acciones del segundo jugador
	 */
	private void panelJ2() {
		J2 = new JPanel();
		J2.setLayout(new GridLayout(1,2));
		J1.setBounds(WIDTH-400, HEIGHT-HEIGHT/6, 400, HEIGHT/6);
		
		JPanel state = new JPanel();
		state.setLayout(new GridLayout(2,1));
		
		JPanel state1 = new JPanel();
		state1.setLayout(new GridLayout(2,1));
		JLabel labelOro = new JLabel("Oro:");
		 cantOroJ2=new JTextField( "100");
		 cantOroJ2.setFocusable(false);
		 eraNumJ2=new JTextField("1");
		 eraNumJ2.setFocusable(false);
		JLabel labelDesarrollo = new JLabel("Nivel de desarrollo:");
		state1.add(labelOro);
		state1.add(cantOroJ2);
		state1.add(labelDesarrollo);
		
		state1.add(eraNumJ2);
		state.add(state1);
		botonEvolve2 = new JButton("Avanzar era (U)");
		state.add(botonEvolve2);
		
		JPanel action = new JPanel();
		action.setLayout(new GridLayout(2,1));
		JLabel unidad = new JLabel(" Unidades ");
		action.add(unidad);
		JPanel action1 = new JPanel();
		action1.setLayout(new GridLayout(1,3));
		botonJ = new JButton("Unidad 1(J)");
		botonK = new JButton("Unidad 2(K)");
		action1.add(botonJ);
		action1.add(botonK);
		action.add(action1);
		
		J2.add(state);
		J2.add(action);
	}
	
	/*
	 * Prepara los elementos necesarios para crear el menú barra con opciones.
	 */
	private void prepareElementosMenu() {
		bar = new JMenuBar();
		menu = new JMenu("Opciones");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Guardar");
		menuSalir = new JMenuItem("Salir");
		
		bar.add(menu);
		menu.add(abrir);
		menu.add(guardar);
		menu.add(menuSalir);
		setJMenuBar(bar);
	}
	
	/*
	 * Prepara el "tablero" en el cual se animará el juego 
	 */
	private void prepareTableroJuego() {
		PanelGame.pg=null;
		tablero = PanelGame.getPanelGame(tipoIA);
		add(tablero, BorderLayout.CENTER);
		tablero.setLayout(null);
		botonBack = new JButton("Volver");
		tablero.add(botonBack);
		botonBack.setBounds(0, ANCHO/2, 200, 50);
		
	}
	
	/*
	 * Prepara los oyentes de cada componente con el cual el usuario puede interactuar
	 */
	private void prepareAcciones(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ActionListener oyenteMenuSalir = new ActionListener(){
			public void actionPerformed(ActionEvent e) {salir();}
		};
		
		ActionListener oyenteAbrir = new ActionListener(){
			public void actionPerformed(ActionEvent e) {try {
				opcionAbrir();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}}
		};
		
		ActionListener oyenteGuardar = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					opcionGuardar();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}};
		
		ActionListener oyenteBotonBack = new ActionListener(){
			public void actionPerformed(ActionEvent e) {tablero.parar();POOAgeOfWarGUI.cargarMenu();}
		};
		
		menuSalir.addActionListener(oyenteMenuSalir);
		abrir.addActionListener(oyenteAbrir);
		guardar.addActionListener(oyenteGuardar);
		botonBack.addActionListener(oyenteBotonBack);
	}
	
	/*
	 * Permite guardar el estado actual del juego.
	 */
	private void opcionGuardar() throws FileNotFoundException, IOException {
		
            JFileChooser fc = new JFileChooser();
            int r = fc.showSaveDialog(this);
            if(r == JFileChooser.APPROVE_OPTION){ tablero.guardar(fc.getSelectedFile());}
	}
	
	/*
	 * permita abrir recrear un estado del juego a partir de un archivo
	 */
	private void opcionAbrir() throws FileNotFoundException, ClassNotFoundException, IOException {
		JFileChooser fc = new JFileChooser();
        int r = fc.showSaveDialog(this);
        if(r == JFileChooser.APPROVE_OPTION){ tablero.abrir(fc.getSelectedFile());}
	}
	
	/*
	 * Prepara las acciones del panel para el primer jugador
	 */
private void prepareAccionesJ1() {
		
		ActionListener oyenteBotonA = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					try {
						tablero.crearSoldadoMelee(1);
					} catch (PAOWException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
		};
		botonA.addActionListener(oyenteBotonA);
				
		ActionListener oyenteBotonS = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					tablero.crearSoldadoTanque(1);
				} catch (PAOWException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		};
		botonS.addActionListener(oyenteBotonS);
				
		ActionListener oyenteBotonEvolve1 = new ActionListener(){
			public void actionPerformed(ActionEvent e) {try {
				tablero.avanzarEra(1);
			} catch (PAOWException e1) { }
			int er=tablero.getEra(1);
			eraNumJ1.setText(Integer.toString(er));}
		};
		botonEvolve1.addActionListener(oyenteBotonEvolve1);
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==e.VK_A){
					try {
						tablero.crearSoldadoMelee(1);
					} catch (PAOWException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				if (e.getKeyCode()==e.VK_S){
					try {
						tablero.crearSoldadoTanque(1);
					} catch (PAOWException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				if (e.getKeyCode()==e.VK_E){
					try {
					tablero.avanzarEra(1);
					int er=tablero.getEra(1);
					eraNumJ1.setText(Integer.toString(er));
					} catch (PAOWException e1) { 
						JOptionPane.showMessageDialog(null, e1.getMessage());}
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}			
		});
	}
	
	/*
	 * Prepara las acciones para el panel del segundo jugador
	 */
	private void prepareAccionesJ2() {
		
		ActionListener oyenteBotonJ = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					tablero.crearSoldadoMelee(2);
				} catch (PAOWException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		};
		botonJ.addActionListener(oyenteBotonJ);
		
		ActionListener oyenteBotonK = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					tablero.crearSoldadoTanque(2);
				} catch (PAOWException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		};
		botonK.addActionListener(oyenteBotonK);
		
		ActionListener oyenteBotonEvolve2 = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					tablero.avanzarEra(2);
					int er=tablero.getEra(2);
					eraNumJ2.setText(Integer.toString(er));
				} catch (PAOWException e1) {JOptionPane.showMessageDialog(null, e1.getMessage());}
			}
		};
		botonEvolve2.addActionListener(oyenteBotonEvolve2);
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==e.VK_J){
					try {
						tablero.crearSoldadoMelee(2);
					} catch (PAOWException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				if (e.getKeyCode()==e.VK_K){
					try {
						tablero.crearSoldadoTanque(2);
					} catch (PAOWException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				if (e.getKeyCode()==e.VK_U){
					try {
						tablero.avanzarEra(2);
						int er=tablero.getEra(2);
						eraNumJ2.setText(Integer.toString(er));
					} catch (PAOWException e1) { JOptionPane.showMessageDialog(null, e1.getMessage());}
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}			
		});
	}

	/*
	 * Actualiza la información del oro de cada jugador
	 */
	public static void actualizLabels(int oroJ1,int oroJ2,int v1,int v2){
		cantOroJ1.setText(Integer.toString(oroJ1));	
		cantOroJ2.setText(Integer.toString(oroJ2));
		cantvidaJ1.setText(Integer.toString(v1));
		cantvidaJ2.setText(Integer.toString(v2));
	}
	
	public static void actualizLabels(int oroJ1,int v1){
		cantOroJ1.setText(Integer.toString(oroJ1));	
		cantvidaJ1.setText(Integer.toString(v1));
	}
	
	/*
	 * Da fin al programa, terminando con la ejecución de la máquina virtual.
	 */
	private void salir(){
		int choose = JOptionPane.showConfirmDialog(null, "¿ Desea salir ?");
		if(choose == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}
