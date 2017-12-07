package presentacion;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class POOAgeOfWarGUI{
	private static Menu inicio = null;
	private static Juego tablero = null;
	private static PreJuego opcionesPJ = null;
	
	private POOAgeOfWarGUI() {
		inicio = new Menu();
	}
	
	public static void cargarTablero(){
		tablero = new Juego();
		inicio = null;
		opcionesPJ.dispose();
		opcionesPJ=null;
	}
	
	public static void cargarMenu(){
		inicio = new Menu();
		
		tablero.dispose();
		tablero = null;
	}
	
	public static void cargarPJ() {
		opcionesPJ = PreJuego.getPreJuego();
		inicio.dispose();
		inicio=null;
		if (tablero!=null) { tablero.dispose();tablero=null;}
		
	} 
	
	public static void main(String[] args) {
		POOAgeOfWarGUI gui = new POOAgeOfWarGUI();
	}

}
