package aplicacion;


import static org.junit.Assert.*;

import org.junit.Test;

public class POOAgeOfWarTest {
	private Arena a;
	private String IA1 = "Ingenuo";
	private String IA2 = "Tacano";
	
	public  POOAgeOfWarTest() {
		a = Arena.creeArena();
	}
	
	@Test
	public void deberiaPonerUnidad() {
		Unidad u = new Melee(1, 1, 1);
		Unidad[][] arr = a.getArena();
		Base b1 = a.getBase(1);
		Base b2 = a.getBase(2);
		
		a.ponerUnidad(b1, u);
		assertTrue(arr[1][0]==u);
		a.ponerUnidad(b2, u);
		assertTrue(arr[19][1]==u);
	}
	
	@Test
	public void deberiaCrearDosJugadores() {
		a.jugadorVsJugador();
		Jugador uno = a.getJ1();
		Jugador dos = a.getJ2();
		assertTrue(uno instanceof Humano);
		assertTrue(dos instanceof Humano);
		a.jugadorVsIA(IA1);
		uno = a.getJ1();
		dos = a.getJ2();
		assertTrue(uno instanceof Humano);
		assertTrue(dos instanceof Ingenuo);
		a.jugadorVsIA(IA2);
		uno = a.getJ1();
		dos = a.getJ2();
		assertTrue(uno instanceof Humano);
		assertTrue(dos instanceof Tacano);
	}
	
	
	/*
	@Test
	public void deberiaIniciarLaArena(){
		Arena r=Arena.creeArena();
		Base bas=r.getBase(1);
		//System.out.print(bas.getDirb()+"dir base en test");
		//System.out.println(bas.getSpawn());
		try {
			r.ponerUnidad(bas, "@");
		} catch (PAOWException e) {
			
		}
		r.actualizar();
		
		Base bas2=r.getBase(2);
		//System.out.println(bas2.getDirb()+"dir base en test pepe");
		try {
			r.ponerUnidad(bas2, "@");
		} catch (PAOWException e) {
			
		}
		r.actualizar();
		try {
			r.ponerUnidad(bas, "@");
		} catch (PAOWException e) {
			
		}
		
		r.actualizar();		
		try {
			r.ponerUnidad(bas2, "@");
		} catch (PAOWException e) {
			
		}
		r.actualizar();		
		try {
			r.ponerUnidad(bas2, "#");
		} catch (PAOWException e) {
			
		}
		r.actualizar();		
		r.actualizar();		
		r.actualizar();		
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();		
		r.actualizar();		
		r.actualizar();		
		r.actualizar();		
		r.actualizar();		
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		
		/*
		r.actualizar();
		r.ponerUnidad(bas, "@");
		System.out.println("bas act");
		r.actualizar();
		r.actualizar();
		*/
	//} 
	/*
	@Test
	public void deberiaPonerEnLaMismaBase(){
		Arena r=new Arena();
		Base bas=r.getBases(1);
		Base bas2=r.getBases(2);	
		
		r.ponerUnidad(bas, "@");
		r.actualizar();
		r.ponerUnidad(bas, "@");
		r.actualizar();
		r.actualizar();
		r.ponerUnidad(bas, "@");
		r.actualizar();
		r.ponerUnidad(bas, "@");
		r.actualizar();
		r.ponerUnidad(bas2, "@");
		
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
	
		
		
	}*/
	

}
