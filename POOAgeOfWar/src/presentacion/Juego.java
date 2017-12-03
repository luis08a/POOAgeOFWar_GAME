package presentacion;
import java.awt.*;
import javax.swing.*;

import aplicacion.Arena;

import java.awt.event.*;

public class Juego extends JFrame {
	//Elementos Men˙ barra
	private JPanel panelOpciones;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem menuSalir;
	//Elementos panel opciones
	private JLabel labelOro;
	private JLabel labelDesarrollo;
	private JButton botonSpawn;
	private JButton botonBack;
	//Elementos Tablero de Juego
	private PanelGame tablero;
	public static final int ALTO=700;
	public static final int ANCHO=1300;
	
	/*
	 * Constructor
	 */
	public Juego(){
		prepareElementos();
		prepareAcciones();
	}
	
	/*
	 * Prepara los elementos necesarios para le interfaz. 
	 */
	private void prepareElementos(){
		setSize(ANCHO,ALTO);
		setVisible(true);
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
		panelOpciones.setLayout(null);
		
		botonSpawn = new JButton("Unidad");
		labelOro = new JLabel("Oro"); 
		labelDesarrollo = new JLabel("Nivel de desarrollo");
		botonBack = new JButton("Back");
		
		panelOpciones.add(botonSpawn);
		panelOpciones.add(labelOro);
		panelOpciones.add(labelDesarrollo);
		panelOpciones.add(botonBack);
		
		botonSpawn.setBounds(200, 10,80,30);
		labelOro.setBounds(20, 10, 40, 10);
		labelDesarrollo.setBounds(20, 20, 120, 10);
		botonBack.setBounds(xEsquina-70, 0, 70, 20);
		
		panelOpciones.setBackground(Color.cyan);
		
		this.add(panelOpciones, BorderLayout.NORTH);
	}
	
	/*
	 * Prepara los elementos necesarios para crear el men√∫ barra con opciones.
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
	 * Prepara el "tablero" en el cual se animar· el juego 
	 */
	private void prepareTableroJuego() {
		tablero = PanelGame.getPanelGame();
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
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcci√≥n");}
		};
		
		ActionListener oyenteGuardar = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcci√≥n");}
		};
		
		ActionListener oyenteBotonSpawn = new ActionListener(){
			public void actionPerformed(ActionEvent e) {tablero.createSprite("name");}
		};
		
		ActionListener oyenteBotonBack = new ActionListener(){
			public void actionPerformed(ActionEvent e) {POOAgeOfWarGUI.cargarMenu();;}
		};
		
		menuSalir.addActionListener(oyenteMenuSalir);
		abrir.addActionListener(oyenteAbrir);
		guardar.addActionListener(oyenteGuardar);
		botonSpawn.addActionListener(oyenteBotonSpawn);
		botonBack.addActionListener(oyenteBotonBack);
		
	}
	
	/*
	 * Da fin al programa, terminando con la ejecuci√≥n de la m√°quina virtual.
	 */
	private void salir(){
		int choose = JOptionPane.showConfirmDialog(null, "ø Desea salir ?");
		if(choose == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}
