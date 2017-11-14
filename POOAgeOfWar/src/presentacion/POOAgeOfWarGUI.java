package presentacion;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class POOAgeOfWarGUI extends JFrame{
	
	private JDialog pantallaInicio;
	private Button jugar;
	private Button salir;
	
	public POOAgeOfWarGUI() {
		prepareElementosVentanaPrincipal();
		prepareAcciones();
	}
	
	private void prepareElementosPantallaJuego() {
		setSize(600,400);
		setVisible(true);
		centre(this);
		setLayout(new BorderLayout());
	}
	
	private void prepareElementosVentanaPrincipal() {
		pantallaInicio = new JDialog();
		pantallaInicio.setTitle("POOAgeOfWar");
		pantallaInicio.setSize(400, 400);
		pantallaInicio.setVisible(true);
		centre(pantallaInicio);
		
		pantallaInicio.setLayout(new GridLayout(3,1));
		
		jugar = new Button("JUGAR");
		salir = new Button("SALIR");
		
		pantallaInicio.add(jugar);
		pantallaInicio.add(salir);	
	}
	
	public void prepareAcciones(){
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
		System.exit(0);
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
