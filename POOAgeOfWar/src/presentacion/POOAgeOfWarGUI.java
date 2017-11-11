package presentacion;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class POOAgeOfWarGUI extends JFrame{
	private JDialog pantallaInicio;
	
	public POOAgeOfWarGUI() {
		prepareElementosVentanaPrincipal();
		prepareAcciones();
	}
	
	private void prepareElementos() {
		
	}
	
	private void prepareElementosVentanaPrincipal() {
		pantallaInicio = new JDialog();
		
	}
	
	public void prepareAcciones(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		POOAgeOfWarGUI gui = new POOAgeOfWarGUI();
		gui.setVisible(true);
	}

}
