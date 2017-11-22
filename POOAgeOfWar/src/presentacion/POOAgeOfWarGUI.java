package presentacion;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class POOAgeOfWarGUI{
	private static Menu inicio = null;
	private static Juego tablero = null;
	
	private POOAgeOfWarGUI() {
		inicio = new Menu();
	}
	
	public static void cargarTablero(){
		tablero = new Juego();
		inicio.dispose();
		inicio = null;
	}
	
	public static void cargarMenu(){
		inicio = new Menu();
		tablero.dispose();
		tablero = null;
	}
	
	public static void main(String[] args) {
		POOAgeOfWarGUI gui = new POOAgeOfWarGUI();
	}

}
