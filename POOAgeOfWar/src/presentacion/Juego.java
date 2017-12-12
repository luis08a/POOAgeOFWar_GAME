package presentacion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
	private JButton botonL;
	//Elementos Tablero de Juego
	private PanelGame tablero;
	public static final int ALTO=700;
	public static final int ANCHO=1300;
	
	
	/*
	 * Constructor
	 */
	public Juego(boolean jcj) {
		this.jcj =jcj;
		prepareElementos();
		prepareAcciones();
		setVisible(true);
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
		
		//panelOpciones.add(new JPanel());
		if(jcj==true) {
			panelJ2();
			prepareAccionesJ2();
			panelOpciones.add(J2);
		}
		
		add(panelOpciones, BorderLayout.SOUTH);
	}
	
	private void panelJ1() {
		J1 = new JPanel();
		J1.setLayout(new GridLayout(1,2));
		J1.setBounds(0, 600, 400, 100);
		
		JPanel state = new JPanel();
		state.setLayout(new GridLayout(2,1));
		
		JPanel state1 = new JPanel();
		state1.setLayout(new GridLayout(2,1));
		JLabel labelOro = new JLabel("Oro");
		JLabel labelDesarrollo = new JLabel("Nivel de desarrollo");
		state1.add(labelOro);
		state1.add(labelDesarrollo);
		state.add(state1);
		botonEvolve1 = new JButton("Avanzar era (E)");
		state.add(botonEvolve1);
		
		JPanel action = new JPanel();
		action.setLayout(new GridLayout(2,1));
		JLabel unidad = new JLabel(" Unidades ");
		action.add(unidad);
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
	
	private void panelJ2() {
		J2 = new JPanel();
		J2.setLayout(new GridLayout(1,2));
		J1.setBounds(WIDTH-400, HEIGHT-HEIGHT/6, 400, HEIGHT/6);
		
		JPanel state = new JPanel();
		state.setLayout(new GridLayout(2,1));
		
		JPanel state1 = new JPanel();
		state1.setLayout(new GridLayout(2,1));
		JLabel labelOro = new JLabel("Oro");
		JLabel labelDesarrollo = new JLabel("Nivel de desarrollo");
		state1.add(labelOro);
		state1.add(labelDesarrollo);
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
		botonL = new JButton("Unidad 3(L)");
		action1.add(botonJ);
		action1.add(botonK);
		action1.add(botonL);
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
		tablero = PanelGame.getPanelGame(true);
		add(tablero, BorderLayout.CENTER);
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
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcción");}
		};
		
		ActionListener oyenteGuardar = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcción");}
		};
		
		
		
		ActionListener oyenteBotonBack = new ActionListener(){
			public void actionPerformed(ActionEvent e) {tablero.parar();POOAgeOfWarGUI.cargarMenu();}
		};
		
		menuSalir.addActionListener(oyenteMenuSalir);
		abrir.addActionListener(oyenteAbrir);
		guardar.addActionListener(oyenteGuardar);
		//botonSpawn.addActionListener(oyenteBotonSpawn);
		//botonBack.addActionListener(oyenteBotonBack);
	}
	
	private void prepareAccionesJ1() {
		
		ActionListener oyenteBotonA = new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
					tablero.createSprite("name",1);}
		};
		botonA.addActionListener(oyenteBotonA);
		
		botonA.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_A){tablero.createSprite("name",1);}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_A){tablero.createSprite("name",1);}
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		ActionListener oyenteBotonS = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcción");}
		};
		botonS.addActionListener(oyenteBotonS);
		
		ActionListener oyenteBotonD = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcción");}
		};
		botonD.addActionListener(oyenteBotonD);
		
		ActionListener oyenteBotonEvolve1 = new ActionListener(){
			public void actionPerformed(ActionEvent e) {tablero.mejora(1);}
		};
		botonEvolve1.addActionListener(oyenteBotonEvolve1);
	}
	
private void prepareAccionesJ2() {
		
		ActionListener oyenteBotonJ = new ActionListener(){
			public void actionPerformed(ActionEvent e) {tablero.createSprite("name",2);}
		};
		botonJ.addActionListener(oyenteBotonJ);
		
		ActionListener oyenteBotonK = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcción");}
		};
		botonK.addActionListener(oyenteBotonK);
		
		ActionListener oyenteBotonL = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcción");}
		};
		botonL.addActionListener(oyenteBotonL);
		
		ActionListener oyenteBotonEvolve2 = new ActionListener(){
			public void actionPerformed(ActionEvent e) {tablero.mejora(2);}
		};
		botonEvolve2.addActionListener(oyenteBotonEvolve2);
		
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
