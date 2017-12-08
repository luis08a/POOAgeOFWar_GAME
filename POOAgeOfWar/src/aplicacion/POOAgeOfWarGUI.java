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
	
	public static void cargarTablero(boolean jcj){
		tablero = new Juego(jcj);
		if (inicio!=null) {
			inicio.dispose();
			inicio = null;
		}
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
		if (tablero!=null) { tablero.dispose();tablero=null;}
		inicio.dispose();
		inicio=null;
	} 
	
	public static void main(String[] args) {
		POOAgeOfWarGUI gui = new POOAgeOfWarGUI();
	}

}
