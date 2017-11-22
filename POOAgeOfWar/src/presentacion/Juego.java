package presentacion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Juego extends JFrame {
	private JPanel panelOpciones;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem menuSalir;
	
	private JLabel labelOro;
	private JLabel labelDesarrollo;
	private JButton botonSpawn;
	private JButton botonBack;
	
	public Juego(){
		prepareElementos();
		prepareAcciones();
	}
	
	private void prepareElementos(){
		setSize(1500,1000);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(null);
		
		preparePanelOpciones();
		prepareElementosMenu();
		
	}
	
	private void preparePanelOpciones(){
		panelOpciones = new JPanel();
		Dimension screen = this.getSize();
		int xEsquina = (screen.width = getSize().width );
		int yEsquina = (screen.height = getSize().height ) /4;
		panelOpciones.setBounds(0, 0, xEsquina, yEsquina);
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
		botonBack.setBounds(520, 0, 70, 20);
		
		panelOpciones.setBackground(java.awt.Color.cyan);
		
		add(panelOpciones);
	}
	
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
	
	private void prepareAcciones(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ActionListener oyenteMenuSalir = new ActionListener(){
			public void actionPerformed(ActionEvent e) {salir();}
		};
		
		ActionListener oyenteAbrir = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcci�n");}
		};
		
		ActionListener oyenteGuardar = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcci�n");}
		};
		
		ActionListener oyenteBotonSpawn = new ActionListener(){
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(null, "En construcci�n");}
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
	private void salir(){
		int choose = JOptionPane.showConfirmDialog(null, "� Desea salir ?");
		if(choose == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}