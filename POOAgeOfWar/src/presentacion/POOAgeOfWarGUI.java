package presentacion;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class POOAgeOfWarGUI extends JFrame{
	//Pantalla inicial
	private JDialog pantallaInicio;
	//Componentes de la pantalla inicial
	private JPanel panelLogo;
	private JPanel panelOpciones;
	private Button jugar;
	private Button salir;
	
	//componentes de la pabtalla de juego
	private JPanel panelOpcionesJugador;
	// Componentes Menú barra pantalla de juego
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem menuSalir;
	//componentes del panel panel opciones jugador
	private JLabel oro;
	private JLabel desarrollo;
	private JButton botonSpawn;
	private JButton botonBack;
	
	private POOAgeOfWarGUI() {
		prepareElementosVentanaPrincipal();
		prepareAcciones();
	}
	
	private void prepareElementosPantallaJuego() {
		setSize(600,400);
		setVisible(true);
		centre(this);
		setLayout(null);
		preparePanelOpcionesJugador();
		prepareElementosMenuJuego();
		
		this.add(panelOpcionesJugador);
	}
	
	private void preparePanelOpcionesJugador(){
		panelOpcionesJugador = new JPanel();
		Dimension screen = this.getSize();
		int xEsquina = (screen.width = getSize().width );
		int yEsquina = (screen.height = getSize().height ) /4;
		panelOpcionesJugador.setBounds(0, 0, xEsquina, yEsquina);
		panelOpcionesJugador.setLayout(null);
		
		botonSpawn = new JButton("a");
		botonSpawn.setBounds(10, 10,30,30);
		
		panelOpcionesJugador.add(botonSpawn);
		
	}
	
	private void prepareElementosMenuJuego() {
		bar = new JMenuBar();
		menu = new JMenu("Opciones");
		abrir = new JMenuItem();
		guardar = new JMenuItem();
		menuSalir = new JMenuItem();
		
		bar.add(menu);
		menu.add(abrir);
		menu.add(guardar);
		menu.add(menuSalir);
	}
	private void prepareElementosVentanaPrincipal() {
		pantallaInicio = new JDialog();
		pantallaInicio.setTitle("POOAgeOfWar");
		pantallaInicio.setSize(400, 400);
		pantallaInicio.setVisible(true);
		centre(pantallaInicio);
		
		pantallaInicio.setLayout(null);
		
		preparePanelInicioOpciones();
		preparePanelInicioLogo();
		
		pantallaInicio.add(panelLogo, BorderLayout.NORTH);
		pantallaInicio.add(panelOpciones,BorderLayout.CENTER);
	}
	private void preparePanelInicioLogo(){
		panelLogo = new JPanel();
		panelLogo.setBounds(0,0,400,100);
		
	}
	
	private void preparePanelInicioOpciones(){
		panelOpciones = new JPanel();
		panelOpciones.setBounds(100,100,200,200);
		panelOpciones.setLayout(new GridLayout(2,1));
		jugar = new Button("JUGAR");
		salir = new Button("SALIR");
		
		panelOpciones.add(jugar);
		panelOpciones.add(salir);
	}
	
	private void prepareAcciones(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		WindowListener oyenteVentanaPrincipal = new WindowAdapter() {
			public void windowClosing( WindowEvent e) { salir();}
		};
		
		ActionListener oyenteBotonJugar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaInicio.setVisible(false);
				prepareElementosPantallaJuego();
			}
		};
		
		ActionListener oyenteBotonSalir = new ActionListener(){
			public void actionPerformed(ActionEvent e) {salir();}
		};
		
		pantallaInicio.addWindowListener(oyenteVentanaPrincipal);
		jugar.addActionListener(oyenteBotonJugar);
		salir.addActionListener(oyenteBotonSalir);
	}
	
	private void salir() {
		int choose = JOptionPane.showConfirmDialog(null, "¿ Desea salir ?");
		if(choose == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	private void centre(Window c) {
		Dimension screen = c.getSize();
		int xEsquina = (screen.width = getSize().width ) /2;
		int yEsquina = (screen.height = getSize().height ) /2;
		c.setLocation(xEsquina, yEsquina);
	}
	public static void main(String[] args) {
		POOAgeOfWarGUI gui = new POOAgeOfWarGUI();
	}

}
